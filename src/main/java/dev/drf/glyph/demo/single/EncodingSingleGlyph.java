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
        String encodedString = encoding.encoder().encodeToString(bytes);
        builder.append(encodedString);
    }

    @Override
    public EncodingSingleGlyph reverse() {
        int bt = encoding.byteInChar();
        int len = bytes.length;
        int buffLen = len / bt;
        byte[] reversed = new byte[len];
        for (int i = 0; i < buffLen; i++) {
            System.arraycopy(bytes, (len - i * bt - bt), reversed, i * bt, bt);
        }
        return new EncodingSingleGlyph(encoding, reversed);
    }

    @Override
    public EncodingSingleGlyph toUpperCase() {
        return new EncodingSingleGlyph(encoding, encoding.toUpperCase(bytes));
    }

    @Override
    public EncodingSingleGlyph toLowerCase() {
        return new EncodingSingleGlyph(encoding, encoding.toLowerCase(bytes));
    }

    @Override
    public EncodingSingleGlyph subGlyph(int start, int end) {
        int len = length();
        if (start < 0 || end < 0 || end > len || start > end) {
            throw new IllegalArgumentException("Illegal sub glyph parameter: start = "
                    + start + ", end = " + end);
        }
        int realLen = (end - start) * encoding.byteInChar();
        byte[] buff = new byte[realLen];
        System.arraycopy(bytes, start * encoding.byteInChar(), buff, 0, realLen);
        return new EncodingSingleGlyph(encoding, buff);
    }

    @Override
    public EncodingSingleGlyph copy() {
        byte[] buff = new byte[bytes.length];
        System.arraycopy(bytes, 0, buff, 0, bytes.length);
        return new EncodingSingleGlyph(encoding, buff);
    }

    @Override
    public int length() {
        int bt = encoding.byteInChar();
        int len = bytes.length;
        return len / bt;
    }

    @Override
    public char charAt(int index) {
        int len = length();
        if (index < 0 || index >= len) {
            throw new IllegalArgumentException("Illegal index parameter: " + index);
        }

        int bt = encoding.byteInChar();
        byte[] buff = new byte[bt];
        System.arraycopy(bytes, index * bt, buff, 0, bt);
        return encoding.toChar(buff);
    }

    public byte[] getBytes() {
        return bytes;
    }
}
