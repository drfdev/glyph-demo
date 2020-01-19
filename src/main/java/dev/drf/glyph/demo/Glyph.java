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
    <T extends Glyph> T reverse();
    <T extends Glyph> T toUpperCase();
    <T extends Glyph> T toLowerCase();
    <T extends Glyph> T subGlyph(int start, int end);
    <T extends Glyph> T copy();
}
