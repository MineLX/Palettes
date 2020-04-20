package com.zyh.pro.palettes.main.core;

import com.zyh.pro.palettes.main.core.view.KeyEvent;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import static com.zyh.pro.palettes.main.core.view.KeyEvent.get;

public class FrameTarget implements IPalettesTarget {

	private final JFrame frame;

	private final int width;

	private final int height;

	private final List<Runnable> cleanups;

	public FrameTarget(JFrame frame, int width, int height) {
		this.frame = frame;
		this.width = width;
		this.height = height;

		cleanups = new ArrayList<>();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cleanups.forEach(Runnable::run);
			}
		});
	}

	@Override
	public void addKeyListener(KeyEvent.KeyListener keyListener) {
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				keyListener.down(get(e.getKeyCode()));
			}

			@Override
			public void keyReleased(java.awt.event.KeyEvent e) {
				keyListener.up(get(e.getKeyCode()));
			}
		});
	}

	@Override
	public void addShutdownCleanUp(Runnable cleanup) {
		cleanups.add(cleanup);
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
}
