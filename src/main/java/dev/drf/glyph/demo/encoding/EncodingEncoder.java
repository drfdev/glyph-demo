package dev.drf.glyph.demo.encoding;

public interface EncodingEncoder {
    String encodeToString(byte[] bytes);
    byte[] encode(byte[] bytes);
}
