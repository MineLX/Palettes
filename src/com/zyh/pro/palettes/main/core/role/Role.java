package com.zyh.pro.palettes.main.core.role;

import com.zyh.pro.palettes.main.core.IPalette;
import com.zyh.pro.palettes.main.core.view.IMotionDispatcher;
import com.zyh.pro.palettes.main.core.view.MotionEvent;

public abstract class Role implements IMotionDispatcher {

	private boolean visible;

	protected Role() {
		visible = true;
	}

	public void paint(IPalette palette) {
		palette.beginPaint();
		draw(palette);
		palette.endPaint();
	}

	protected final void draw(IPalette palette) {
		if (!visible)
			return;
		onDraw(palette);
	}

	public void hide() {
		visible = false;
	}

	public void show() {
		visible = true;
	}

	protected abstract void onDraw(IPalette palette);

	@Override
	public boolean dispatchMotionEvent(MotionEvent event) {
		return false;
	}
}
