package dev.drf.glyph.demo.group;

import dev.drf.glyph.demo.Glyph;

import java.util.Iterator;

public class ArrayGlyph<T extends Glyph> extends GroupGlyph<T> {
    @Override
    public int groupLength() {
        // TODO
        return 0;
    }

    @Override
    public T glyphAt(int index) {
        // TODO
        return null;
    }

    @Override
    public GroupGlyph<T> subGroup(int start, int end) {
        // TODO
        return null;
    }

    @Override
    public void build(StringBuilder builder) {
        // TODO
    }

    @Override
    public Glyph reverse() {
        // TODO
        return null;
    }

    @Override
    public Glyph toUpperCase() {
        // TODO
        return null;
    }

    @Override
    public Glyph toLowerCase() {
        // TODO
        return null;
    }

    @Override
    public Glyph subGlyph(int start, int end) {
        // TODO
        return null;
    }

    @Override
    public int length() {
        // TODO
        return 0;
    }

    @Override
    public char charAt(int index) {
        // TODO
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO
        return null;
    }
}
