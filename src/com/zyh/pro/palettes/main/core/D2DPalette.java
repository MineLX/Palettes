package com.zyh.pro.palettes.main.core;

import javax.swing.*;
import java.awt.*;

public class D2DPalette extends Palette {

	static {
		System.load("C:\\Users\\Remain\\Desktop\\NEW EDITION\\SplasherLib\\Debug\\libSplasherLib.dll");
	}

	public D2DPalette(IPalettesTarget target, JFrame frame) {
		super(target);
		createD2D(frame);
	}

	@Override
	protected void onCleanup() {
		cleanup();
	}

	@Override
	public void clear(int value) {
		fillRect(0, 0, getWidth(), getHeight(), value);
	}

	private native boolean createD2D(Frame canvas);

	private native void cleanup();

	@Override
	public native void beginPaint();

	@Override
	public native void endPaint();

	private native void drawBitmap(int bitmapID);

	@Override
	public native void drawText(String text, int x, int y, int width, int height, int value);

	@Override
	public native void fillRect(int x, int y, int width, int height, int value);

	@Override
	public native void rect(int x, int y, int width, int height, int value);

	@Override
	public native void oval(int centerX, int centerY, int radiusX, int radiusY, int value);

	@Override
	public native void fillOval(int centerX, int centerY, int radiusX, int radiusY, int value);

	@Override
	public native void line(int startX, int startY, int endX, int endY, int value);

	@Override
	public int getWidth() {
		return target.getWidth();
	}

	@Override
	public int getHeight() {
		return target.getHeight();
	}
}
