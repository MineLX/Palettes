package com.zyh.pro.palettes.main.core;

import java.util.ArrayList;
import java.util.List;

public class Context {

	public final int width;

	public final int height;

	private final List<Runnable> cleanups;

	Context(IPalettesTarget target, int width, int height) {
//		this.width = target.getWidth();
//		this.height = target.getHeight();
		this.width = width;
		this.height = height;

		cleanups = new ArrayList<>();
		target.addShutdownCleanUp(() -> cleanups.forEach(Runnable::run));
	}

	public void addCleanUp(Runnable cleanup) {
		cleanups.add(cleanup);
	}
}
