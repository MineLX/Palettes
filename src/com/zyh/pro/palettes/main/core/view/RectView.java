package com.zyh.pro.palettes.main.core.view;

import com.zyh.pro.palettes.main.core.IPalette;

import java.util.Map;

public class RectView extends View {

	private final int value;

	public RectView(Map<String, String> attributes, int value) {
		super(attributes);

		this.value = value;
	}

	@Override
	protected void onViewDraw(IPalette palette) {
		palette.fillRect(0, 0, getWidth(), getHeight(), value);
	}
}
