package dev.drf.glyph.demo.group;

import dev.drf.glyph.demo.single.CharSequenceGlyph;
import dev.drf.glyph.demo.single.SingleCharGlyph;
import org.junit.Test;

import static org.junit.Assert.*;

public class GroupGlyphTest {
    @Test
    public void reverseTest() {
        SingleCharGlyph sg1 = new SingleCharGlyph('a');
        SingleCharGlyph sg2 = new SingleCharGlyph('b');

        TextGlyph tg = new TextGlyph();
        tg.add(sg1);
        tg.add(sg2);

        assertEquals(sg1, tg.glyphAt(0));
        assertEquals(sg2, tg.glyphAt(1));

        TextGlyph reversed = (TextGlyph) tg.reverse();

        assertEquals(sg2, reversed.glyphAt(0));
        assertEquals(sg1, reversed.glyphAt(1));
    }

    @Test
    public void copyTest() {
        SingleCharGlyph sg1 = new SingleCharGlyph('a');
        SingleCharGlyph sg2 = new SingleCharGlyph('b');

        TextGlyph tg = new TextGlyph();
        tg.add(sg1);
        tg.add(sg2);

        TextGlyph copy = (TextGlyph) tg.copy();

        assertEquals(sg1, tg.glyphAt(0));
        assertEquals(sg2, tg.glyphAt(1));

        assertSame(sg1, tg.glyphAt(0));
        assertSame(sg2, tg.glyphAt(1));

        assertEquals(sg1, copy.glyphAt(0));
        assertEquals(sg2, copy.glyphAt(1));

        assertNotSame(sg1, copy.glyphAt(0));
        assertNotSame(sg2, copy.glyphAt(1));
    }

    @Test
    public void charAtTest() {
        SingleCharGlyph sg1 = new SingleCharGlyph('a');
        SingleCharGlyph sg2 = new SingleCharGlyph('b');

        TextGlyph tg = new TextGlyph();
        tg.add(sg1);
        tg.add(sg2);

        char ch1 = tg.charAt(0);
        char ch2 = tg.charAt(1);

        assertEquals('a', ch1);
        assertEquals('b', ch2);
    }

    @Test
    public void charAt2Test() {
        CharSequenceGlyph g1 = new CharSequenceGlyph("abc");
        CharSequenceGlyph g2 = new CharSequenceGlyph("def");

        TextGlyph tg = new TextGlyph();
        tg.add(g1);
        tg.add(g2);

        assertEquals('a', tg.charAt(0));
        assertEquals('b', tg.charAt(1));
        assertEquals('c', tg.charAt(2));
        assertEquals('d', tg.charAt(3));
        assertEquals('e', tg.charAt(4));
        assertEquals('f', tg.charAt(5));
    }

    @Test
    public void subGlyphTest() {
        CharSequenceGlyph g1 = new CharSequenceGlyph("abc");
        CharSequenceGlyph g2 = new CharSequenceGlyph("def");

        TextGlyph tg = new TextGlyph();
        tg.add(g1);
        tg.add(g2);

        TextGlyph sub1 = (TextGlyph) tg.subGlyph(0, 2);
        TextGlyph sub2 = (TextGlyph) tg.subGlyph(2, 4);
        TextGlyph sub3 = (TextGlyph) tg.subGlyph(4, 6);

        TextGlyph sub4 = (TextGlyph) tg.subGlyph(0, 3);
        TextGlyph sub5 = (TextGlyph) tg.subGlyph(3, 6);

        assertEquals("ab", sub1.toString());
        assertEquals("cd", sub2.toString());
        assertEquals("ef", sub3.toString());

        assertEquals("abc", sub4.toString());
        assertEquals("def", sub5.toString());
    }
}
