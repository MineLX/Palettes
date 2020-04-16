package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.Stage;
import com.zyh.pro.palettes.main.D2DPaletteFactory;
import com.zyh.pro.palettes.main.IPaletteFactory;
import com.zyh.pro.palettes.main.TestRole;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TestRoleTest {

	public static void main(String[] args) {
		d2d();
	}

	private static void d2d() {
		IPaletteFactory factory = new D2DPaletteFactory();
		factory.addKeyListener(new MyKeyListener());

		Stage stage = new Stage(factory, 1000, 600, 0);
		stage.addRole(new TestRole(stage.getContext()));
	}

	private static class MyKeyListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	}
}
