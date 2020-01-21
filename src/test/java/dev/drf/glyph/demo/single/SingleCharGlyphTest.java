package dev.drf.glyph.demo.single;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleCharGlyphTest {
    @Test
    public void buildTest() {
        SingleCharGlyph glyph = new SingleCharGlyph('z');
        StringBuilder builder = new StringBuilder();

        glyph.build(builder);

        assertEquals("z", builder.toString());
    }

    @Test
    public void reverseTest() {
        SingleCharGlyph glyph = new SingleCharGlyph('a');

        SingleCharGlyph reversed = glyph.reverse();

        assertEquals("a", reversed.toString());
        assertEquals(glyph, reversed);
    }

    @Test
    public void toUpperCaseTest() {
        SingleCharGlyph glyph = new SingleCharGlyph('a');

        SingleCharGlyph uppered = glyph.toUpperCase();

        assertEquals("A", uppered.toString());
    }

    @Test
    public void toLowerCaseTest() {
        SingleCharGlyph glyph = new SingleCharGlyph('B');

        SingleCharGlyph lowered = glyph.toLowerCase();

        assertEquals("b", lowered.toString());
    }

    @Test(expected = UnsupportedOperationException.class
    )
    public void subGlyphTest() {
        SingleCharGlyph glyph = new SingleCharGlyph('s');

        glyph.subGlyph(1, 2);
    }

    @Test
    public void copyTest() {
        SingleCharGlyph glyph = new SingleCharGlyph('p');

        SingleCharGlyph copy = glyph.copy();

        assertEquals(glyph, copy);
    }

    @Test
    public void lengthTest() {
        SingleCharGlyph glyph = new SingleCharGlyph('2');

        assertEquals(1, glyph.length());
    }

    @Test
    public void charAtTest() {
        SingleCharGlyph glyph = new SingleCharGlyph('5');

        char ch = glyph.charAt(0);

        assertEquals('5', ch);
    }

    @Test(expected = IllegalArgumentException.class)
    public void charAtTest_whenIndexNotZero() {
        SingleCharGlyph glyph = new SingleCharGlyph('5');

        glyph.charAt(2);
    }
}
