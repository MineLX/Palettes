package com.zyh.pro.palettes.main;

public class RectRole extends Role {

	private final int x;

	private final int y;

	private final int width;

	private final int height;

	private final int value;

	public RectRole(int x, int y, int width, int height, int value) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.value = value;
	}

	@Override
	protected void onDraw(IPalette palette) {
		palette.fillRect(x, y, width, height, value);
	}
}
