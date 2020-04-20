package com.zyh.pro.palettes.main.core.view;

public class Pointer {

	private boolean isDown;

	public boolean down() {
		if (isDown)
			return false;
		return isDown = true;
	}

	public boolean move() {
		return isDown;
	}

	public boolean up() {
		if (isDown) {
			isDown = false;
			return true;
		}
		return false;
	}
}
