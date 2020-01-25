package dev.drf.glyph.demo.encoding;

public interface EncodingDecoder {

    byte[] decode(String string);
    byte[] decode(byte[] bytes);
}
