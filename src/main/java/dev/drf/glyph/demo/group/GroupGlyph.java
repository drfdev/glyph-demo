package dev.drf.glyph.demo.group;

import dev.drf.glyph.demo.AbstractGlyph;
import dev.drf.glyph.demo.Glyph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Objects.requireNonNull;

abstract class GroupGlyph<T extends Glyph> extends AbstractGlyph implements Iterable<T> {
    protected List<T> glyphs;
    protected int length;

    public GroupGlyph() {
        glyphs = new ArrayList<>();
        recalculateLength();
    }

    public GroupGlyph(List<T> glyphs) {
        this.glyphs = new ArrayList<>(requireNonNull(glyphs));
        recalculateLength();
    }

    protected abstract GroupGlyph<T> buildNewGroup(List<T> glyphs);

    public int groupLength() {
        return glyphs.size();
    }

    public T glyphAt(int index) {
        return glyphs.get(index);
    }

    public GroupGlyph<T> subGroup(int start, int end) {
        return buildNewGroup(glyphs.subList(start, end));
    }

    public void add(T glyph) {
        glyphs.add(glyph);
        recalculateLength();
    }

    @Override
    public void build(StringBuilder builder) {
        glyphs.forEach(item -> item.build(builder));
    }

    @Override
    public GroupGlyph<T> reverse() {
        final int len = glyphs.size();
        List<T> reversed = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            reversed.add(i, glyphs.get(len - i - 1));
        }
        return buildNewGroup(reversed);
    }

    @Override
    public GroupGlyph<T> toUpperCase() {
        GroupGlyph<T> copy = copy();
        copy.forEach(Glyph::toUpperCase);
        return copy;
    }

    @Override
    public GroupGlyph<T> toLowerCase() {
        GroupGlyph<T> copy = copy();
        copy.forEach(Glyph::toLowerCase);
        return copy;
    }

    @Override
    public int length() {
        return glyphs.stream()
                .mapToInt(Glyph::length)
                .sum();
    }

    @Override
    public GroupGlyph<T> copy() {
        final int len = glyphs.size();
        List<T> reversed = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            reversed.add(i, glyphs.get(i).copy());
        }
        return buildNewGroup(reversed);
    }

    @Override
    public Iterator<T> iterator() {
        return glyphs.iterator();
    }

    protected void recalculateLength() {
        int length = 0;
        for (T glyph : glyphs) {
            length += glyph.length();
        }
        this.length = length;
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index > length()) {
            throw new IllegalArgumentException("Illegal index parameter: " + index);
        }
        int firstIndex = 0;
        int glyphLength = 0;
        for (T glyph : glyphs) {
            glyphLength += glyph.length();
            if (index >= firstIndex && index < glyphLength) {
                return glyph.charAt(index - firstIndex);
            }
            firstIndex = glyphLength;
        }
        throw new IllegalArgumentException("Wrong index parameter: " + index);
    }

    @Override
    public GroupGlyph<T> subGlyph(int start, int end) {
        int len = length();
        if (start < 0 || end < 0 || end > len || start > end) {
            throw new IllegalArgumentException("Illegal sub glyph parameter: start = "
                    + start + ", end = " + end);
        }
        List<T> sub = new ArrayList<>();
        int firstIndex = 0;
        int glyphLength = 0;
        for (T glyph : glyphs) {
            glyphLength += glyph.length();
            if ((start >= firstIndex && start < glyphLength)
                    || (end >= firstIndex && end < glyphLength)) {
                sub.add(glyph.subGlyph(
                        max(start - firstIndex, 0),
                        min(end - firstIndex, glyph.length())
                ));
            }
            firstIndex = glyphLength;
        }
        return buildNewGroup(sub);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GroupGlyph<?> that = (GroupGlyph<?>) o;
        return Objects.equals(glyphs, that.glyphs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(glyphs);
    }
}
