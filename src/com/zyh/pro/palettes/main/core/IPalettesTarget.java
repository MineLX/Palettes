package com.zyh.pro.palettes.main.core;

import com.zyh.pro.palettes.main.core.view.IMotionDispatcher;
import com.zyh.pro.palettes.main.core.view.KeyEvent;
import com.zyh.pro.palettes.main.core.view.MotionEvent;

public interface IPalettesTarget {
	void addKeyListener(KeyEvent.KeyListener keyListener);

	void addMotionDispatcher(IMotionDispatcher dispatcher);

	void addShutdownCleanUp(Runnable cleanup);

	int getWidth();

	int getHeight();

	void shutdown();
}
