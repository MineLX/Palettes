package com.zyh.pro.palettes.main.charmap;

public class OffsetCharMap extends CharMap {

	private final int width;

	private final int height;

	public OffsetCharMap(char[][] source, int offsetX, int offsetY, int width, int height) {
		super(offsetX, offsetY, source);

		this.width = width;
		this.height = height;
	}

	@Override
	public char[][] toArray() {
		return rectAt(source, location.getX(0), location.getY(0), width, height);
	}

	private char[][] rectAt(char[][] source, int x, int y, int width, int height) {
		char[][] result = new char[height][width];
		for (int h = 0; h < height; h++)
			System.arraycopy(source[y + h], x, result[h], 0, width);
		return result;
	}
}
