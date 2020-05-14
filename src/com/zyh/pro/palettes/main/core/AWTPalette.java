package com.zyh.pro.palettes.main.core;

import javax.swing.*;
import java.awt.*;

public class AWTPalette extends Palette {

	private final Graphics graphics;

	public AWTPalette(IPalettesTarget target, JFrame frame) {
		super(target);
		graphics = frame.getGraphics();
	}

	@Override
	public void beginPaint() {
	}

	@Override
	public void endPaint() {
	}

	@Override
	public void clear(int value) {
		fillRect(0, 0, getWidth(), getHeight(), value);
	}

	private void setColor(int value) {
		graphics.setColor(new Color(value));
	}

	@Override
	public void rect(int x, int y, int width, int height, int value) {
		setColor(value);
		graphics.drawRect(x, y, width, height);
	}

	@Override
	public void oval(int centerX, int centerY, int radiusX, int radiusY, int value) {
		setColor(value);
		graphics.drawOval(centerX - radiusX, centerY - radiusY,
				radiusX + radiusX, radiusY + radiusY);
	}

	@Override
	public void fillRect(int x, int y, int width, int height, int value) {
		setColor(value);
		graphics.fillRect(x, y, width, height);
	}

	@Override
	public void fillOval(int centerX, int centerY, int radiusX, int radiusY, int value) {
		setColor(value);
		graphics.fillOval(centerX - radiusX, centerY - radiusY,
				radiusX + radiusX, radiusY + radiusY);
	}

	@Override
	public void line(int startX, int startY, int endX, int endY, int value) {
		setColor(value);
		graphics.drawLine(startX, startY, endX, endY);
	}

	@Override
	public void drawText(String text, int x, int y, int width, int height, int value) {

	}

	@Override
	public int getWidth() {
		return target.getWidth();
	}

	@Override
	public int getHeight() {
		return target.getHeight();
	}
}
