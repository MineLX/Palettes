package com.zyh.pro.palettes.main;

public class ClearGroup extends ViewGroup {

	private final int value;

	public ClearGroup(int value) {
		this.value = value;
	}

	@Override
	protected void onSelfDraw(IPalette palette) {
		palette.clear(value);
	}
}
