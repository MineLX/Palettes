package com.zyh.pro.palettes.main.core;

import javax.swing.*;
import java.awt.*;

public abstract class FramePalettesFactory implements IPalettesFactory {

	static final int WIDTH_INTERVAL = 8;

	static final int HEIGHT_INTERVAL = 31;

	private final JFrame frame;

	private final FrameTarget target;

	FramePalettesFactory(int width, int height) {
		frame = new PaintLessFrame();
		int width1 = width + WIDTH_INTERVAL;
		int height1 = height + HEIGHT_INTERVAL;
		System.out.println("width1 = " + width1);
		System.out.println("height1 = " + height1);
		frame.setSize(width1, height1);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);

		target = new FrameTarget(frame, width, height);
	}

	@Override
	public IPalette createPalette() {
		return createPaletteByFrame(target, frame);
	}

	@Override
	public IPalettesTarget createTarget() {
		return target;
	}

	protected abstract IPalette createPaletteByFrame(IPalettesTarget target, JFrame frame);

	private static class PaintLessFrame extends JFrame {
		@Override
		public void paint(Graphics g) {
		}
	}
}
