package com.zyh.pro.palettes.main.core;

import com.zyh.pro.animator.main.animators.Animator;
import com.zyh.pro.animator.main.animators.Animators;
import com.zyh.pro.palettes.main.core.role.CompositeRole;
import com.zyh.pro.palettes.main.core.role.Role;
import com.zyh.pro.palettes.main.core.view.KeyEvent;

public class RoleStage {

	private final CompositeRole rootRole;

	private final IPalette palette;

	private final IPalettesTarget target;

	public RoleStage(IPalettesFactory palettesFactory, CompositeRole rootRole) {
		this.rootRole = rootRole;
		target = palettesFactory.createTarget();
		palette = palettesFactory.createPalette();

		target.addMotionDispatcher(rootRole);
		startRepaint();
	}

	private void startRepaint() {
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
		rootRole.addRole(role);
	}

	private void repaint() {
		rootRole.paint(palette);
	}

	public void addKeyListener(KeyEvent.KeyListener keyListener) {
		target.addKeyListener(keyListener);
	}

	public IPalettesTarget getTarget() {
		return target;
	}

	public CompositeRole getRoot() {
		return rootRole;
	}
}
