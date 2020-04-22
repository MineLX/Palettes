package com.zyh.pro.palettes.main.core;

import com.zyh.pro.palettes.main.core.view.MotionDispatcher;
import com.zyh.pro.palettes.main.core.view.KeyEvent;

public interface IPalettesTarget {
	void addKeyListener(KeyEvent.KeyListener keyListener);

	void addMotionDispatcher(MotionDispatcher dispatcher);

	void addShutdownCleanUp(Runnable cleanup);

	int getWidth();

	int getHeight();

	void shutdown();
}
