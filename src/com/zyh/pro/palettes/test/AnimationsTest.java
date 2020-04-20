package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.D2DPalettesFactory;
import com.zyh.pro.palettes.main.core.Stage;
import com.zyh.pro.palettes.main.core.role.BallRole;
import com.zyh.pro.palettes.main.core.role.ColorRole;
import com.zyh.pro.palettes.main.core.view.KeyEvent;

public class AnimationsTest {

	private static BallRole ball;

	public static void main(String[] args) throws InterruptedException {
		Stage stage = new Stage(new D2DPalettesFactory(1000, 600), 0);
		stage.addKeyListener(new KeyEvent.KeyListener() {
			@Override
			public void onDown(KeyEvent keyEvent) {
				ball.animate();
			}

			@Override
			public void onUp(KeyEvent keyEvent) {
			}
		});
		ColorRole container = new ColorRole(0x063A66);
		stage.addRole(container);

		ball = new BallRole(stage.getTarget());
		container.addRole(ball);
		Thread.sleep(2000);
		container.fadeTo(0x3FA7FF);
		ball.animate();
	}
}
