package dev.drf.glyph.demo.single;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class ContentGlyph extends SingleGlyph {
    private final String content;
    private final boolean skipUnsupportException;

    public ContentGlyph(String content) {
        this.content = requireNonNull(content);
        this.skipUnsupportException = true;
    }

    public ContentGlyph(String content, boolean skipUnsupportException) {
        this.content = content;
        this.skipUnsupportException = skipUnsupportException;
    }

    @Override
    public void build(StringBuilder builder) {
        builder.append(content);
    }

    @Override
    public ContentGlyph reverse() {
        if (!skipUnsupportException) {
            throw new UnsupportedOperationException("reverse method not supported for content glyph");
        }
        return this;
    }

    @Override
    public ContentGlyph toUpperCase() {
        if (!skipUnsupportException) {
            throw new UnsupportedOperationException("toUpperCase method not supported for content glyph");
        }
        return this;
    }

    @Override
    public ContentGlyph toLowerCase() {
        if (!skipUnsupportException) {
            throw new UnsupportedOperationException("toLowerCase method not supported for content glyph");
        }
        return this;
    }

    @Override
    public ContentGlyph subGlyph(int start, int end) {
        if (!skipUnsupportException) {
            throw new UnsupportedOperationException("subGlyph method not supported for content glyph");
        }
        return this;
    }

    @Override
    public ContentGlyph copy() {
        return new ContentGlyph(content);
    }

    @Override
    public int length() {
        return content.length();
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index > content.length()) {
            throw new IllegalArgumentException("Illegal index parameter: " + index);
        }
        return content.charAt(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContentGlyph that = (ContentGlyph) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
