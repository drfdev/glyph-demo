package dev.drf.glyph.demo.single;

import java.util.Objects;

public class SingleCharGlyph extends SingleGlyph {
    private final char ch;

    public SingleCharGlyph(char ch) {
        this.ch = ch;
    }

    @Override
    public void build(StringBuilder builder) {
        builder.append(ch);
    }

    @Override
    public SingleCharGlyph reverse() {
        return copy();
    }

    @Override
    public SingleCharGlyph toUpperCase() {
        return new SingleCharGlyph(Character.toUpperCase(ch));
    }

    @Override
    public SingleCharGlyph toLowerCase() {
        return new SingleCharGlyph(Character.toLowerCase(ch));
    }

    @Override
    public SingleCharGlyph subGlyph(int start, int end) {
        throw new UnsupportedOperationException("SingleCharGlyph not support subGlyph method");
    }

    @Override
    public SingleCharGlyph copy() {
        return new SingleCharGlyph(ch);
    }

    @Override
    public int length() {
        return 1;
    }

    @Override
    public char charAt(int index) {
        if (index != 0) {
            throw new IllegalArgumentException("Illegal index, must be zero");
        }
        return ch;
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
