package com.zyh.pro.palettes.main;

public interface IPalette {
	void beginPaint();

	void endPaint();

	void addCleanUp(Runnable cleanup);

	void clear(int value);

	void rect(int x, int y, int width, int height, int value);

	void oval(int centerX, int centerY, int radiusX, int radiusY, int value);

	void fillRect(int x, int y, int width, int height, int value);

	void fillOval(int centerX, int centerY, int radiusX, int radiusY, int value);

	void line(int startX, int startY, int endX, int endY, int value);

	int getWidth();

	int getHeight();

	default void fillOval(Oval ball, int value) {
		fillOval(ball.getCenterX(), ball.getCenterY(), ball.getRadiusX(), ball.getRadiusY(), value);
	}
}
