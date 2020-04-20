package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.FrameTarget;
import com.zyh.pro.palettes.main.core.view.KeyEvent;
import org.junit.Test;

import javax.swing.*;

public class FrameTargetTest {

	public static void main(String[] arg) {
		JFrame frame = new JFrame();
		frame.setSize(50, 50);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);

		FrameTarget target = new FrameTarget(frame);
		target.addKeyListener(new KeyEvent.KeyListener() {
			@Override
			public void onDown(KeyEvent keyEvent) {
				System.out.println("onDown");
			}

			@Override
			public void onUp(KeyEvent keyEvent) {
				System.out.println("onUp");
			}
		});
	}
}
