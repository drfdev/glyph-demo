package dev.drf.glyph.demo.single;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class CharSequenceGlyph extends SingleGlyph {
    private final CharSequence charSequence;

    public CharSequenceGlyph(CharSequence charSequence) {
        this.charSequence = requireNonNull(charSequence, "Require not null charSequence!");
    }

    @Override
    public void build(StringBuilder builder) {
        builder.append(charSequence);
    }

    @Override
    public CharSequenceGlyph reverse() {
        int len = charSequence.length();
        char[] reversed = new char[len];
        for (int i = 0; i < len; i++) {
            reversed[i] = charSequence.charAt(len - i - 1);
        }
        return new CharSequenceGlyph(new String(reversed));
    }

    @Override
    public CharSequenceGlyph toUpperCase() {
        int len = charSequence.length();
        char[] array = new char[len];
        for (int i = 0; i < len; i++) {
            array[i] = Character.toUpperCase(charSequence.charAt(i));
        }
        return new CharSequenceGlyph(new String(array));
    }

    @Override
    public CharSequenceGlyph toLowerCase() {
        int len = charSequence.length();
        char[] array = new char[len];
        for (int i = 0; i < len; i++) {
            array[i] = Character.toLowerCase(charSequence.charAt(i));
        }
        return new CharSequenceGlyph(new String(array));
    }

    @Override
    public CharSequenceGlyph subGlyph(int start, int end) {
        int len = charSequence.length();
        if (start < 0 || end < 0 || end > len || start > end) {
            throw new IllegalArgumentException("Illegal sub glyph parameter: start = "
                    + start + ", end = " + end);
        }
        return new CharSequenceGlyph(charSequence.subSequence(start, end));
    }

    @Override
    public CharSequenceGlyph copy() {
        int len = charSequence.length();
        char[] array = new char[len];
        for (int i = 0; i < len; i++) {
            array[i] = charSequence.charAt(i);
        }
        return new CharSequenceGlyph(new String(array));
    }

    @Override
    public int length() {
        return charSequence.length();
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index > charSequence.length()) {
            throw new IllegalArgumentException("Illegal index parameter: " + index);
        }
        return charSequence.charAt(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CharSequenceGlyph glyph = (CharSequenceGlyph) o;
        return Objects.equals(charSequence, glyph.charSequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(charSequence);
    }
}
