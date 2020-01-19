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
    public Glyph copy() {
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
