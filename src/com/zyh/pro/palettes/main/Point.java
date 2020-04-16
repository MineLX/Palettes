package com.zyh.pro.palettes.main;

import static java.lang.Math.*;

public class Point {

	private double x;

	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void rotate(int atX, int atY, int deg) {
		double rag = deg * PI / 180;
		double resultX = (x - atX) * cos(rag) - (y - atY) * sin(rag) + atX;
		double resultY = (x - atX) * sin(rag) + (y - atY) * cos(rag) + atY;
		x = resultX;
		y = resultY;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point))
			return false;
		Point another = (Point) obj;
		return another.x == x && another.y == y;
	}

	@Override
	public String toString() {
		return "Point(" + x + ", " + y + ")";
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
}
