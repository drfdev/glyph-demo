package dev.drf.glyph.demo.encoding;

public interface Encoding {
    int byteInChar();

    EncodingEncoder encoder();
    EncodingDecoder decoder();

    byte[] toUpperCase(byte[] bts);
    byte[] toLowerCase(byte[] bts);

    char toChar(byte[] bts);
}
