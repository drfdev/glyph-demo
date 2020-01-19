package dev.drf.glyph.demo.group;

import dev.drf.glyph.demo.EncodingGlyph;

import java.nio.charset.Charset;
import java.util.List;

public class EncodingGroupGlyph<T extends EncodingGlyph> extends GroupGlyph<T> implements EncodingGlyph {
    public EncodingGroupGlyph() {
    }

    public EncodingGroupGlyph(List<T> glyphs) {
        super(glyphs);
    }

    @Override
    public Charset encoding() {
        // TODO
        return null;
    }

    @Override
    public char charAt(int index) {
        // TODO
        return 0;
    }

    @Override
    protected EncodingGroupGlyph<T> buildNewGroup(List<T> glyphs) {
        return new EncodingGroupGlyph<>(glyphs);
    }

    @Override
    public EncodingGroupGlyph<T> subGlyph(int start, int end) {
        // TODO
        return null;
    }
}
