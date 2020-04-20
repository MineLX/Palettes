package com.zyh.pro.palettes.main.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Palette implements IPalette {

	private final List<Runnable> cleanups;

	protected final Context context;

	Palette(Context context) {
		this.context = context;
		cleanups = new ArrayList<>();

		context.addCleanUp(this::cleanupPalette);
	}

	@Override
	public void addCleanUp(Runnable cleanup) {
		cleanups.add(cleanup);
	}

	private void cleanupPalette() {
		System.out.println("start clean inner palette ...");
		cleanups.forEach(Runnable::run);
		System.out.println("start Palette cleanup");
		onCleanup();
	}

	protected void onCleanup() {
	}
}
