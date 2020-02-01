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
        if (index < 0 || index > length()) {
            throw new IllegalArgumentException("Illegal index parameter: " + index);
        }
        int tempLength = 0;
        int currentLength = 0;
        for (T glyph : glyphs) {
            tempLength += glyph.length();
            if (index > tempLength) {
                return glyph.charAt(currentLength + index);
            }
            currentLength = tempLength;
        }
        throw new IllegalArgumentException("Wrong index parameter: " + index);
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
