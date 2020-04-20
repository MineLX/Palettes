package com.zyh.pro.palettes.main.core.view;

public interface I2D {

	void setX(int x);

	void setY(int y);

	void setWidth(int width);

	void setHeight(int height);

	int getX();

	int getY();

	int getWidth();

	int getHeight();

	default void setLocation(int x, int y) {
		setX(x);
		setY(y);
	}

	default void setSize(int width, int height) {
		setWidth(width);
		setHeight(height);
	}

	default void setBound(int x, int y, int width, int height) {
		setLocation(x, y);
		setSize(width, height);
	}
}
