package dev.drf.glyph.demo.single;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContentGlyphTest {

    @Test
    public void buildTest() {
        ContentGlyph glyph = new ContentGlyph("Test glyph");
        StringBuilder builder = new StringBuilder();

        glyph.build(builder);

        assertEquals("Test glyph", builder.toString());
    }

    @Test
    public void reverseTest() {
        ContentGlyph glyph = new ContentGlyph("Test glyph");

        ContentGlyph reversed = glyph.reverse();

        assertSame(glyph, reversed);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void reverseTest_withException() {
        ContentGlyph glyph = new ContentGlyph("Reverse with exception", false);

        glyph.reverse();
    }

    @Test
    public void toUpperCaseTest() {
        ContentGlyph glyph = new ContentGlyph("Test glyph");

        ContentGlyph uppered = glyph.toUpperCase();

        assertSame(glyph, uppered);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void toUpperCaseTest_withException() {
        ContentGlyph glyph = new ContentGlyph("Test glyph", false);

        glyph.toUpperCase();
    }

    @Test
    public void toLowerCaseTest() {
        ContentGlyph glyph = new ContentGlyph("Test glyph");

        ContentGlyph lowered = glyph.toLowerCase();

        assertSame(glyph, lowered);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void toLowerCaseTest_withException() {
        ContentGlyph glyph = new ContentGlyph("Test glyph", false);

        glyph.toLowerCase();
    }

    @Test
    public void subGlyphTest() {
        ContentGlyph glyph = new ContentGlyph("Test glyph");

        ContentGlyph subbed = glyph.subGlyph(0, 1);

        assertSame(glyph, subbed);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subGlyphTest_withException() {
        ContentGlyph glyph = new ContentGlyph("Test glyph", false);

        glyph.subGlyph(0, 1);
    }

    @Test
    public void copyTest() {
        ContentGlyph glyph = new ContentGlyph("Test glyph");

        ContentGlyph copy = glyph.copy();

        assertEquals(glyph, copy);
        assertNotSame(glyph, copy);
    }

    @Test
    public void lengthTest() {
        ContentGlyph glyph = new ContentGlyph("Length test");

        int len = glyph.length();

        assertEquals("Length test".length(), len);
    }

    @Test
    public void charAtTest() {
        ContentGlyph glyph = new ContentGlyph("Char at test");

        char ch = glyph.charAt(5);

        assertEquals('a', ch);
    }

    @Test(expected = IllegalArgumentException.class)
    public void charAtTest_withNegativeIndex() {
        ContentGlyph glyph = new ContentGlyph("Char at test");

        glyph.charAt(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void charAtTest_withGreaterIndex() {
        ContentGlyph glyph = new ContentGlyph("Char at test");

        glyph.charAt(5000);
    }
}
