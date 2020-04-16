package com.zyh.pro.palettes.main;

public class D2DBitmap {

	private final int id;

	public D2DBitmap(int width, int height, int blockWidth) {
		id = createBitmap(width, height, blockWidth);
	}

	int getID() {
		return id;
	}

	private native int createBitmap(int width, int height, int blockWidth);
}
