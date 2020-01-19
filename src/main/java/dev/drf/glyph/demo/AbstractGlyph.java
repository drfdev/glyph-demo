package dev.drf.glyph.demo;

public abstract class AbstractGlyph implements Glyph {
    @Override
    public CharSequence subSequence(int start, int end) {
        return subGlyph(start, end);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        build(builder);
        return builder.toString();
    }
}
