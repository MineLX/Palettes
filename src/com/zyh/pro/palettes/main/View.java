package com.zyh.pro.palettes.main;

public class View extends Role {

	private final OffsetPalette offsetPalette;

	int x;

	int y;

	int width;

	int height;

	public View() {
		offsetPalette = new OffsetPalette(View.this);
	}

	@Override
	protected final void onDraw(IPalette palette) {
		offsetPalette.setDecorated(palette);
		onViewDraw(offsetPalette);
	}

	protected void onViewDraw(IPalette palette) {
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void setBound(int x, int y, int width, int height) {
		setLocation(x, y);
		setSize(width, height);
	}
}
