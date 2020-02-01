package dev.drf.glyph.demo.group;

import dev.drf.glyph.demo.AbstractGlyph;
import dev.drf.glyph.demo.Glyph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
}
