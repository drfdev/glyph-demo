package dev.drf.glyph.demo.single;

import dev.drf.glyph.demo.encoding.Encoding;
import dev.drf.glyph.demo.encoding.EncodingDecoder;
import dev.drf.glyph.demo.encoding.EncodingEncoder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EncodingSingleGlyphTest {
    private Encoding encodingStub = new Encoding() {
        @Override public int byteInChar() {
            return 2;
        }
        @Override public EncodingEncoder encoder() {
            return null;
        }
        @Override public EncodingDecoder decoder() {
            return null;
        }
        @Override public byte[] toUpperCase(byte[] bts) {
            return bts;
        }
        @Override public byte[] toLowerCase(byte[] bts) {
            return bts;
        }
        @Override public char toChar(byte[] bts) {
            return 0;
        }
    };

    @Test
    public void reverseTest() {
        byte[] bts = new byte[] {0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x10};

        EncodingSingleGlyph glyph = new EncodingSingleGlyph(encodingStub, bts);
        EncodingSingleGlyph reversed = glyph.reverse();

        byte[] reversedBytes = reversed.getBytes();

        assertEquals(0x09, reversedBytes[0]);
        assertEquals(0x10, reversedBytes[1]);
        assertEquals(0x07, reversedBytes[2]);
        assertEquals(0x08, reversedBytes[3]);
        assertEquals(0x05, reversedBytes[4]);
        assertEquals(0x06, reversedBytes[5]);
        assertEquals(0x03, reversedBytes[6]);
        assertEquals(0x04, reversedBytes[7]);
        assertEquals(0x01, reversedBytes[8]);
        assertEquals(0x02, reversedBytes[9]);
    }
}
