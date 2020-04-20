package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.D2DPalettesFactory;
import com.zyh.pro.palettes.main.core.IPalettesFactory;
import com.zyh.pro.palettes.main.core.Stage;
import com.zyh.pro.palettes.main.core.role.TestRole;
import com.zyh.pro.palettes.main.core.view.KeyEvent;
import com.zyh.pro.palettes.main.core.view.KeyEvent.KeyListener;

public class TestRoleTest {

	public static void main(String[] args) {
		d2d();
	}

	private static void d2d() {
		IPalettesFactory factory = new D2DPalettesFactory(1000, 600);
		Stage stage = new Stage(factory, 0);
		stage.addKeyListener(new KeyListener() {
			@Override
			public void onDown(KeyEvent keyEvent) {
				System.out.println("keyEvent = " + keyEvent);
			}
			@Override
			public void onUp(KeyEvent keyEvent) {

			}
		});
		stage.addRole(new TestRole(stage.getTarget()));
	}

}
