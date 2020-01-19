package dev.drf.glyph.demo;

public interface Glyph extends CharSequence {
    /*
    CharSequence:
    public int length();
    public char charAt(int index);
    public CharSequence subSequence(int start, int end);

    Object:
    public String toString();
	public boolean equals();
	public int hashCode();
     */

    void build(StringBuilder builder);
    Glyph reverse();
    Glyph toUpperCase();
    Glyph toLowerCase();
    Glyph subGlyph(int start, int end);
}
