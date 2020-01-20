package dev.drf.glyph.demo.single;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class CharSequenceGlyphTest {
    @Test
    public void buildTest() {
        CharSequenceGlyph glyph = new CharSequenceGlyph("test sequence");
        StringBuilder builder = new StringBuilder();

        glyph.build(builder);

        assertEquals("test sequence", builder.toString());
    }

    @Test
    public void reverseTest() {
        CharSequenceGlyph glyph = new CharSequenceGlyph("test sequence");

        CharSequenceGlyph reversed = glyph.reverse();

        assertEquals("ecneuqes tset", reversed.toString());
    }

    @Test
    public void toUpperCaseTest() {
        CharSequenceGlyph glyph = new CharSequenceGlyph("Upper Case Test");

        CharSequenceGlyph uppered = glyph.toUpperCase();

        assertEquals("UPPER CASE TEST", uppered.toString());
    }

    @Test
    public void toLowerCaseTest() {
        CharSequenceGlyph glyph = new CharSequenceGlyph("LoWEr CaSE TeST");

        CharSequenceGlyph lowered = glyph.toLowerCase();

        assertEquals("lower case test", lowered.toString());
    }

    @Test
    public void subGlyphTest() {
        CharSequenceGlyph glyph = new CharSequenceGlyph("sub_Glyph_Test");

        CharSequenceGlyph subbed = glyph.subGlyph(4, 9);

        assertEquals("Glyph", subbed.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void subGlyphTest_whenNegativeParamsValue() {
        CharSequenceGlyph glyph = new CharSequenceGlyph("wrong params");

        glyph.subGlyph(-1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void subGlyphTest_whenWrongParamsValue() {
        CharSequenceGlyph glyph = new CharSequenceGlyph("wrong params");

        glyph.subGlyph(500, 500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void subGlyphTest_whenStartBiggerEndParamValue() {
        CharSequenceGlyph glyph = new CharSequenceGlyph("wrong params");

        glyph.subGlyph(5, 2);
    }

    @Test
    public void copyTest() {
        CharSequenceGlyph glyph = new CharSequenceGlyph("copy test");

        CharSequenceGlyph copy = glyph.copy();

        assertEquals(glyph, copy);
        assertNotSame(glyph, copy);
    }

    @Test
    public void lengthTest() {
        CharSequenceGlyph glyph = new CharSequenceGlyph("1234567890");

        int val = glyph.length();

        assertEquals(10, val);
    }

    @Test
    public void charAtTest() {
        CharSequenceGlyph glyph = new CharSequenceGlyph("abcde");

        char ch0 = glyph.charAt(0);
        char ch1 = glyph.charAt(1);
        char ch2 = glyph.charAt(2);
        char ch3 = glyph.charAt(3);
        char ch4 = glyph.charAt(4);

        assertEquals('a', ch0);
        assertEquals('b', ch1);
        assertEquals('c', ch2);
        assertEquals('d', ch3);
        assertEquals('e', ch4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void charAtTest_whenNegativeValue() {
        CharSequenceGlyph glyph = new CharSequenceGlyph("abcde");

        glyph.charAt(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void charAtTest_whenBiggerThenLengthValue() {
        CharSequenceGlyph glyph = new CharSequenceGlyph("abcde");

        glyph.charAt(100);
    }
}
