package com.zyh.pro.palettes.main;

public class DecoratedPalette implements IPalette {

	protected IPalette decorated;

	void setDecorated(IPalette decorated) {
		this.decorated = decorated;
	}

	@Override
	public void beginPaint() {
		decorated.beginPaint();
	}

	@Override
	public void endPaint() {
		decorated.endPaint();
	}

	@Override
	public void addCleanUp(Runnable cleanup) {
		decorated.addCleanUp(cleanup);
	}

	@Override
	public void clear(int value) {
		decorated.clear(value);
	}

	@Override
	public void rect(int x, int y, int width, int height, int value) {
		decorated.rect(x, y, width, height, value);
	}

	@Override
	public void oval(int centerX, int centerY, int radiusX, int radiusY, int value) {
		decorated.oval(centerX, centerY, radiusX, radiusY, value);
	}

	@Override
	public void fillRect(int x, int y, int width, int height, int value) {
		decorated.fillRect(x, y, width, height, value);
	}

	@Override
	public void fillOval(int centerX, int centerY, int radiusX, int radiusY, int value) {
		decorated.fillOval(centerX, centerY, radiusX, radiusY, value);
	}

	@Override
	public void line(int startX, int startY, int endX, int endY, int value) {
		decorated.line(startX, startY, endX, endY, value);
	}

	@Override
	public int getWidth() {
		return decorated.getWidth();
	}

	@Override
	public int getHeight() {
		return decorated.getHeight();
	}
}
