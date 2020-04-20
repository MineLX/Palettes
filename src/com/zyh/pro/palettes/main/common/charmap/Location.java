package com.zyh.pro.palettes.main.common.charmap;

public class Location {

	private final int x;

	private final int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX(int at) {
		return at + x;
	}

	public int getY(int at) {
		return at + y;
	}
}
