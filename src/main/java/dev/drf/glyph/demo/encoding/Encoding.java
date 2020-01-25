package dev.drf.glyph.demo.encoding;

public interface Encoding {
    int byteInChar();

    EncodingEncoder encoder();
    EncodingDecoder decoder();
}
