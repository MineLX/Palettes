package com.zyh.pro.palettes.main.core;

import com.zyh.pro.animator.main.animators.Animator;
import com.zyh.pro.animator.main.animators.Animators;
import com.zyh.pro.palettes.main.core.role.ClearRole;
import com.zyh.pro.palettes.main.core.role.CompositeRole;
import com.zyh.pro.palettes.main.core.role.Role;
import com.zyh.pro.palettes.main.core.view.KeyEvent;

public class Stage {

	private final CompositeRole root;

	private final IPalette palette;

	private final IPalettesTarget target;

	public Stage(IPalettesFactory paletteFactory, int backgroundValue) {
		target = paletteFactory.createTarget();
		palette = paletteFactory.createPalette();
		root = new ClearRole(backgroundValue);

		Animator repaint = Animators.justDoIt(this::repaint);
		palette.addCleanUp(() -> stopRepaint(repaint));
		repaint.start();
	}

	private void stopRepaint(Animator repaint) {
		repaint.stop();
		try { // FIXME 2020/4/16  wait for me!!! shutdown animator
			Thread.sleep(200);
		} catch (InterruptedException ignored) {
		}
	}

	public void addRole(Role role) {
		root.addRole(role);
	}

	private void repaint() {
		root.paint(palette);
	}

	public void addKeyListener(KeyEvent.KeyListener keyListener) {
		target.addKeyListener(keyListener);
	}

	public IPalettesTarget getTarget() {
		return target;
	}
}
