package com.zyh.pro.palettes.main.shapebean;

import com.zyh.pro.animator.main.animators.valueanimator.evaluations.Evaluator;

public class Oval {

	private final Point center;

	private int radiusX;

	private int radiusY;

	public Oval(int centerX, int centerY, int radiusX, int radiusY) {
		this.radiusX = radiusX;
		this.radiusY = radiusY;
		center = new Point(centerX, centerY);
	}

	public void rotate(int atX, int atY, int deg) {
		center.rotate(atX, atY, deg);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Oval))
			return false;
		Oval another = (Oval) obj;
		return getCenterX() == another.getCenterX() &&
				getCenterY() == another.getCenterY() &&
				radiusX == another.radiusX &&
				radiusY == another.radiusY;
	}

	public int getCenterX() {
		return (int) center.getX();
	}

	public int getCenterY() {
		return (int) center.getY();
	}

	public int getRadiusX() {
		return radiusX;
	}

	public int getRadiusY() {
		return radiusY;
	}

	@Override
	public String toString() {
		return "Oval(" + getCenterX() + ", " + getCenterX() + ", " + radiusX + ", " + radiusY + ")";
	}

	public static class OvalEvaluator implements Evaluator<Oval> {
		private final Oval oval = new Oval(0, 0, 0, 0);

		@Override
		public Oval evaluate(float f, Oval start, Oval end) {
			oval.center.setX(convert(start.getCenterX(), end.getCenterX(), f));
			oval.center.setY(convert(start.getCenterY(), end.getCenterY(), f));
			oval.radiusX = convert(start.radiusX, end.radiusX, f);
			oval.radiusY = convert(start.radiusY, end.radiusY, f);
			return oval;
		}

		private int convert(int start, int end, float f) {
			return (int) (start + (end - start) * f);
		}
	}
}
