package com.zyh.pro.palettes.main.core.role;

import com.zyh.pro.palettes.main.core.IPalette;

public class LineRole extends Role {

	private final int startX;

	private final int startY;

	private final int endX;

	private final int endY;

	private final int value;

	public LineRole(int startX, int startY, int endX, int endY, int value) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.value = value;
	}

	@Override
	protected void onDraw(IPalette palette) {
		palette.line(startX, startY, endX, endY, value);
	}
}
