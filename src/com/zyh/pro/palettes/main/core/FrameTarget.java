package com.zyh.pro.palettes.main.core;

import com.zyh.pro.palettes.main.core.view.KeyEvent;

import javax.swing.*;
import java.awt.event.KeyAdapter;

import static com.zyh.pro.palettes.main.core.view.KeyEvent.get;

public class FrameTarget {

	private final JFrame frame;

	public FrameTarget(JFrame frame) {
		this.frame = frame;
	}

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
}
