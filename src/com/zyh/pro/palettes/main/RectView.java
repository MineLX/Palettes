package com.zyh.pro.palettes.main;

public class RectView extends View {

	@Override
	protected void onViewDraw(IPalette palette) {
		palette.fillRect(0, 0, getWidth(), getHeight(), 0xff00ff);
	}
}
