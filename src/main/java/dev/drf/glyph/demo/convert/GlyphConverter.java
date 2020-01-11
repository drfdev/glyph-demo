package dev.drf.glyph.demo.convert;

import dev.drf.glyph.demo.Glyph;

public interface GlyphConverter {
    Glyph convert(CharSequence string);
}
