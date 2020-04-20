package com.zyh.pro.palettes.main.core;

import com.zyh.pro.palettes.main.core.IPaletteFactory;

import java.util.ArrayList;
import java.util.List;

public class Context {

	public final int width;

	public final int height;

	private final List<Runnable> cleanups;

	Context(IPaletteFactory paletteFactory, int width, int height) {
		this.width = width;
		this.height = height;

		cleanups = new ArrayList<>();
		paletteFactory.addOnWindowClosed(() -> cleanups.forEach(Runnable::run)); // FIXME 2020/4/16  wait for me!!!   responsibility switching
	}

	public void addCleanUp(Runnable cleanup) {
		cleanups.add(cleanup);
	}
}
