package com.zyh.pro.palettes.main;

import java.util.Map;

public class RectView extends View {

	public RectView(Map<String, String> attributes) {
		super(attributes);
	}

	@Override
	protected void onViewDraw(IPalette palette) {
		palette.fillRect(0, 0, getWidth(), getHeight(), 0xff00ff);
	}
}
