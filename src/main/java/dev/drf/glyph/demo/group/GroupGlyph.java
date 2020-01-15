package dev.drf.glyph.demo.group;

import dev.drf.glyph.demo.AbstractGlyph;
import dev.drf.glyph.demo.Glyph;

public abstract class GroupGlyph<T extends Glyph> extends AbstractGlyph implements Iterable<T> {
    /*
    public Iterator<Glyph> iterator();
     */

    public abstract int groupLength();
    public abstract T glyphAt(int index);
    public abstract GroupGlyph<T> subGroup(int start, int end);
}
