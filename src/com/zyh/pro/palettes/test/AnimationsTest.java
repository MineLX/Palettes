package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.D2DPaletteFactory;
import com.zyh.pro.palettes.main.core.Stage;
import com.zyh.pro.palettes.main.core.role.BallRole;
import com.zyh.pro.palettes.main.core.role.ColorRole;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AnimationsTest {

	private static BallRole ball;

	public static void main(String[] args) throws InterruptedException {
		D2DPaletteFactory paletteFactory = new D2DPaletteFactory();
		paletteFactory.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				ball.animate();
			}
		});
		Stage stage = new Stage(paletteFactory, 1000, 600, 0);
		ColorRole container = new ColorRole(0x063A66);
		stage.addRole(container);

		ball = new BallRole(stage.getContext());
		container.addRole(ball);
		Thread.sleep(2000);
		container.fadeTo(0x3FA7FF);
		ball.animate();
	}
}
