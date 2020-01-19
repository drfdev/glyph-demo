package dev.drf.glyph.demo.single;

import dev.drf.glyph.demo.Glyph;

import java.util.Objects;

public class SingleCharGlyph extends SingleGlyph {
    private final char ch;

    public SingleCharGlyph(char ch) {
        this.ch = ch;
    }

    @Override
    public void build(StringBuilder builder) {
        // TODO
    }

    @Override
    public SingleCharGlyph reverse() {
        // TODO
        return null;
    }

    @Override
    public SingleCharGlyph toUpperCase() {
        // TODO
        return null;
    }

    @Override
    public SingleCharGlyph toLowerCase() {
        // TODO
        return null;
    }

    @Override
    public SingleCharGlyph subGlyph(int start, int end) {
        // TODO
        return null;
    }

    @Override
    public SingleCharGlyph copy() {
        return new SingleCharGlyph(ch);
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SingleCharGlyph that = (SingleCharGlyph) o;
        return ch == that.ch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ch);
    }
}
