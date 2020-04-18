package com.zyh.pro.palettes.main;

public class OffsetPalette extends DecoratedPalette {

	private final View view;

	OffsetPalette(View view) {
		this.view = view;
	}

	@Override
	public void clear(int value) {
		decorated.fillRect(view.x, view.y, view.getWidth(), view.getHeight(), value);
	}

	@Override
	public void rect(int x, int y, int width, int height, int value) {
		decorated.rect(view.x + x, view.y + y, width, height, value);
	}

	@Override
	public void oval(int centerX, int centerY, int radiusX, int radiusY, int value) {
		decorated.oval(view.x + centerX, view.y + centerY, radiusX, radiusY, value);
	}

	@Override
	public void fillRect(int x, int y, int width, int height, int value) {
		decorated.fillRect(view.x + x, view.y + y, width, height, value);
	}

	@Override
	public void fillOval(int centerX, int centerY, int radiusX, int radiusY, int value) {
		decorated.fillOval(view.x + centerX, view.y + centerY, radiusX, radiusY, value);
	}

	@Override
	public void line(int startX, int startY, int endX, int endY, int value) {
		decorated.line(view.x + startX, view.y + startY, view.x + endX, view.y + endY, value);
	}
}
