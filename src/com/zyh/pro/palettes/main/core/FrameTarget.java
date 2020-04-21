package com.zyh.pro.palettes.main.core;

import com.zyh.pro.palettes.main.core.view.IMotionDispatcher;
import com.zyh.pro.palettes.main.core.view.KeyEvent;
import com.zyh.pro.palettes.main.core.view.MotionEvent;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import static com.zyh.pro.palettes.main.core.view.KeyEvent.get;
import static com.zyh.pro.palettes.main.core.view.MotionEvent.MotionType.*;
import static com.zyh.pro.palettes.main.core.view.MotionEvent.get;

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
	public void addMotionDispatcher(IMotionDispatcher dispatcher) {
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispatcher.dispatchMotionEvent(get(DOWN, e.getX(), e.getY()));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				dispatcher.dispatchMotionEvent(get(UP, e.getX(), e.getY()));
			}

		});
		frame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				dispatcher.dispatchMotionEvent(get(MOVE, e.getX(), e.getY()));
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

	@Override
	public void shutdown() {
		frame.dispose();
	}
}
