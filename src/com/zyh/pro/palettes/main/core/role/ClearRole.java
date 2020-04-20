package com.zyh.pro.palettes.main.core.role;

import com.zyh.pro.palettes.main.core.IPalette;

public class ClearRole extends CompositeRole {

	private final int value;

	public ClearRole(int value) {
		this.value = value;
	}

	@Override
	protected void onBackground(IPalette palette) {
		palette.clear(value);
	}
}
