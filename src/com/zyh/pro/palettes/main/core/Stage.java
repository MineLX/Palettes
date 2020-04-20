package com.zyh.pro.palettes.main.core;

import com.zyh.pro.animator.main.animators.Animator;
import com.zyh.pro.animator.main.animators.Animators;
import com.zyh.pro.palettes.main.core.role.ClearRole;
import com.zyh.pro.palettes.main.core.role.CompositeRole;
import com.zyh.pro.palettes.main.core.role.Role;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;

public class Stage {

	private final CompositeRole root;

	private final IPalette palette;

	private final Context context;

	public Stage(IPaletteFactory paletteFactory, int width, int height, int backgroundValue) {
		context = new Context(paletteFactory, width, height);
		palette = paletteFactory.createPalette(context);
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

	public Context getContext() {
		return context;
	}
}
