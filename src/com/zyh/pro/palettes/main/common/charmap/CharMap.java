package com.zyh.pro.palettes.main.common.charmap;

import java.util.Arrays;

public class CharMap {

	private static final char CHAR_SPACE = ' ';

	protected final Location location;

	protected final char[][] source;

	protected CharMap(int locationX, int locationY, char[][] source) {
		this.source = source;
		location = new Location(locationX, locationY);
	}

	private CharMap(int locationX, int locationY, int width, int height, char defValue) {
		this(locationX, locationY, new char[height][width]);

		for (char[] line : source)
			Arrays.fill(line, defValue);
	}

	private CharMap(int locationX, int locationY, int width, int height) {
		this(locationX, locationY, width, height, CHAR_SPACE);
	}

	public final void set(int x, int y, char value) {
		source[location.getY(y)][location.getX(x)] = value;
	}

	public final char get(int x, int y) {
		return source[location.getY(y)][location.getX(x)];
	}

	public final CharMap rect(int x, int y, int width, int height) {
		return new OffsetCharMap(source, location.getX(x), location.getY(y), width, height);
	}

	public int getWidth() {
		return source[0].length;
	}

	public int getHeight() {
		return source.length;
	}

	public char[][] toArray() {
		return source;
	}

	public static CharMap of(char[][] source) {
		return new CharMap(0, 0, source);
	}

	public static CharMap withSize(int width, int height) {
		return new CharMap(0, 0, width, height);
	}

	public static CharMap withSizeAndDefVal(int width, int height, char def) {
		return new CharMap(0, 0, width, height, def);
	}
}
