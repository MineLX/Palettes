package com.zyh.pro.palettes.main;

public class Rect {

	private final Point leftTop;

	private final Point leftBottom;

	private final Point rightTop;

	private final Point rightBottom;

	public Rect(int x, int y, int width, int height) {
		leftTop = new Point(x, y);
		leftBottom = new Point(x, y + height);
		rightTop = new Point(x + width, y);
		rightBottom = new Point(x + width, y + height);
	}

	public void rotate(int atX, int atY, int deg) {
		leftTop.rotate(atX, atY, deg);
		leftBottom.rotate(atX, atY, deg);
		rightTop.rotate(atX, atY, deg);
		rightBottom.rotate(atX, atY, deg);
	}


	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Rect) {
			Rect another = (Rect) obj;
			return leftTop.equals(another.leftTop) &&
					leftBottom.equals(another.leftBottom) &&
					rightTop.equals(another.rightTop) &&
					rightBottom.equals(another.rightBottom);
		}
		return false;
	}
}
