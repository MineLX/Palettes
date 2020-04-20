package com.zyh.pro.palettes.main.core;

import com.zyh.pro.palettes.main.core.view.KeyEvent;

public interface IPalettesTarget {
	void addKeyListener(KeyEvent.KeyListener keyListener);

	void addShutdownCleanUp(Runnable cleanup);

	int getWidth();

	int getHeight();
}
