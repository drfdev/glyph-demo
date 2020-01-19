package dev.drf.glyph.demo.group;

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
}
