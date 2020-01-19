package dev.drf.glyph.demo.group;

import dev.drf.glyph.demo.Glyph;

import java.util.List;

public class TextGlyph<T extends Glyph> extends GroupGlyph<T> {
    public TextGlyph() {
    }

    public TextGlyph(List<T> glyphs) {
        super(glyphs);
    }

    @Override
    public char charAt(int index) {
        // TODO
        return 0;
    }

    @Override
    protected TextGlyph<T> buildNewGroup(List<T> glyphs) {
        return new TextGlyph<>(glyphs);
    }

    @Override
    public TextGlyph<T> subGlyph(int start, int end) {
        // TODO
        return null;
    }
}
