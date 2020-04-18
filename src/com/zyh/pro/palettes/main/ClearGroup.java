package com.zyh.pro.palettes.main;

import java.util.HashMap;
import java.util.Map;

public class ClearGroup extends ViewGroup {

	private final int value;

	public ClearGroup(Map<String, String> map, int value) {
		super(map);

		this.value = value;
	}

	@Override
	protected void onSelfDraw(IPalette palette) {
		palette.clear(value);
	}
}
