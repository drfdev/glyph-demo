package dev.drf.glyph.demo.group;

import dev.drf.glyph.demo.EncodingGlyph;
import dev.drf.glyph.demo.encoding.Encoding;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class EncodingGroupGlyph<T extends EncodingGlyph> extends GroupGlyph<T>
        implements EncodingGlyph {
    private final Encoding encoding;

    public EncodingGroupGlyph(Encoding encoding) {
        this.encoding = requireNonNull(encoding);
    }

    public EncodingGroupGlyph(Encoding encoding, List<T> glyphs) {
        super(glyphs);
        this.encoding = requireNonNull(encoding);
    }

    @Override
    public Encoding encoding() {
        return encoding;
    }

    @Override
    public char charAt(int index) {
        // TODO
        return 0;
    }

    @Override
    protected EncodingGroupGlyph<T> buildNewGroup(List<T> glyphs) {
        return new EncodingGroupGlyph<>(encoding, glyphs);
    }

    @Override
    public EncodingGroupGlyph<T> subGlyph(int start, int end) {
        // TODO
        return null;
    }
}
