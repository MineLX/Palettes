package com.zyh.pro.palettes.main.core;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class Palette implements IPalette {

	private final List<Runnable> cleanups;

	protected IPalettesTarget target;

	Palette(IPalettesTarget target) {
		this.target = target;
		cleanups = new ArrayList<>();

		target.addShutdownCleanUp(this::cleanupPalette);
	}

	@Override
	public void addCleanUp(Runnable cleanup) {
		cleanups.add(cleanup);
	}

	private void cleanupPalette() {
		System.out.println("start cleaning before palette ...");
		cleanups.forEach(Runnable::run);
		System.out.println("start Palettes' cleanup ...");
		onCleanup();
		System.out.println("Palettes' cleanups has done.");
	}

	protected void onCleanup() {
	}
}
