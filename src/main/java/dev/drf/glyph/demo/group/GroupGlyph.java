package dev.drf.glyph.demo.group;

import dev.drf.glyph.demo.AbstractGlyph;
import dev.drf.glyph.demo.Glyph;

public abstract class GroupGlyph extends AbstractGlyph implements Iterable<Glyph> {
    /*
    public Iterator<Glyph> iterator();
     */

    public abstract int groupLength();
    public abstract Glyph glyphAt(int index);
    public abstract GroupGlyph subGroup(int start, int end);
}
