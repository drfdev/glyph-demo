package dev.drf.glyph.demo.single;

import dev.drf.glyph.demo.EncodingGlyph;
import dev.drf.glyph.demo.encoding.Encoding;

import static java.util.Objects.requireNonNull;

public class EncodingSingleGlyph extends SingleGlyph implements EncodingGlyph {
    private final Encoding encoding;
    private final byte[] bytes;

    public EncodingSingleGlyph(Encoding encoding, byte[] bytes) {
        this.encoding = requireNonNull(encoding);
        this.bytes = requireNonNull(bytes);
    }

    @Override
    public Encoding encoding() {
        return encoding;
    }

    @Override
    public void build(StringBuilder builder) {
        // TODO
    }

    @Override
    public EncodingSingleGlyph reverse() {
        // TODO
        return null;
    }

    @Override
    public EncodingSingleGlyph toUpperCase() {
        // TODO
        return null;
    }

    @Override
    public EncodingSingleGlyph toLowerCase() {
        // TODO
        return null;
    }

    @Override
    public EncodingSingleGlyph subGlyph(int start, int end) {
        // TODO
        return null;
    }

    @Override
    public EncodingSingleGlyph copy() {
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
}
