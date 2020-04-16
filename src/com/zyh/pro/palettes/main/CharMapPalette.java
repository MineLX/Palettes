package com.zyh.pro.palettes.main;

import com.zyh.pro.palettes.main.charmap.CharMap;
import com.zyh.pro.palettes.main.charmap.StringCharArrayTransformer;

public class CharMapPalette extends Palette {

	private final CharMap map;

	public CharMapPalette(Context context, int width, int height) {
		super(context);
		map = CharMap.withSize(width, height);
	}

	public String toPlainText() {
		return new StringCharArrayTransformer().backward(map.toArray());
	}

	@Override
	public void fillRect(int x, int y, int width, int height, int value) {
		for (int h = 0; h < height; h++)
			for (int w = 0; w < width; w++)
				map.set(x + w, y + h, (char) value);
	}

	@Override
	public void fillOval(int centerX, int centerY, int radiusX, int radiusY, int value) {

	}

	@Override
	public void line(int startX, int startY, int endX, int endY, int value) {
		int width = endX - startX + 1;
		int height = endY - startY + 1;
		fillRect(startX, startY, width, height, value);
	}

	@Override
	public int getWidth() {
		return map.getWidth();
	}

	@Override
	public int getHeight() {
		return map.getHeight();
	}

	@Override
	public void beginPaint() {
	}

	@Override
	public void endPaint() {
	}

	@Override
	public void clear(int value) {

	}

	@Override
	public void rect(int x, int y, int width, int height, int value) {

	}

	@Override
	public void oval(int centerX, int centerY, int radiusX, int radiusY, int value) {

	}
}
