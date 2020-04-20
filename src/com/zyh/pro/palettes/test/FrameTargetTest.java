package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.FrameTarget;
import com.zyh.pro.palettes.main.core.IPalettesTarget;
import com.zyh.pro.palettes.main.core.view.KeyEvent;

import javax.swing.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FrameTargetTest {

	public static void main(String[] arg) {
		JFrame frame = new JFrame();
		frame.setSize(250, 250);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);

		IPalettesTarget target = new FrameTarget(frame, 250, 250);
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
		target.addShutdownCleanUp(() -> System.out.println("cleanup"));
		assertThat(target.getWidth(), is(250));
		assertThat(target.getHeight(), is(250));
	}
}
