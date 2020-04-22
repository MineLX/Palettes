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
		frame.setSize(width + WIDTH_INTERVAL, height + HEIGHT_INTERVAL);
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
