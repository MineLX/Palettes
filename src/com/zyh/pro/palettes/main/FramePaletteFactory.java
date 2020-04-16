package com.zyh.pro.palettes.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class FramePaletteFactory implements IPaletteFactory {

	private static final int WIDTH_INTERVAL = 16;

	private static final int HEIGHT_INTERVAL = 37;

	private final JFrame frame;

	private final List<Runnable> cleanups;

	FramePaletteFactory() {
		cleanups = new ArrayList<>();

		frame = new PaintLessFrame();
		frame.addWindowListener(new CleanupListener());
		frame.setVisible(true);
	}

	@Override
	public IPalette createPalette(Context context) {
		frame.setSize(context.width + WIDTH_INTERVAL, context.height + HEIGHT_INTERVAL);
		return createPaletteByFrame(context, frame);
	}

	protected abstract IPalette createPaletteByFrame(Context context, JFrame frame);

	@Override
	public void addKeyListener(KeyListener keyListener) {
		frame.addKeyListener(keyListener);
	}

	@Override
	public void addOnWindowClosed(Runnable cleanup) {
		cleanups.add(cleanup);
	}

	private static class PaintLessFrame extends JFrame {
		@Override
		public void paint(Graphics g) {
		}
	}

	protected class CleanupListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("CleanupListener cleanups.size = " + cleanups.size());
			for (Runnable cleanup : cleanups)
				cleanup.run();
			frame.dispose();
		}
	}
}
