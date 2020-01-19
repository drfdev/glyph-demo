package dev.drf.glyph.demo.group;

import dev.drf.glyph.demo.single.SingleCharGlyph;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GroupGlyphTest {
    @Test
    public void reverse() {
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
}
