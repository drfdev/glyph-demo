package dev.drf.glyph.demo.builder;

import dev.drf.glyph.demo.Glyph;

public interface GlyphBuilder<T extends Glyph> {
    T build();
}
