package com.zyh.pro.palettes.main.core;

import com.zyh.pro.palettes.main.core.role.ClearRole;
import com.zyh.pro.palettes.main.core.view.IMotionDispatcher;
import com.zyh.pro.palettes.main.core.view.MotionEvent;
import com.zyh.pro.palettes.main.core.view.View;

import java.util.Stack;

public class ViewNavigator {

	private final IPalettesTarget target;

	private final IPalette palette;

	private final Stack<View> views;

	private final ClearRole backView;

	public ViewNavigator(IPalettesFactory palettesFactory) {
		views = new Stack<>();
		target = palettesFactory.createTarget();
		palette = palettesFactory.createPalette();
		backView = new ClearRole(0);

		target.addMotionDispatcher(new MotionDispatcher());
	}

	public void forward(View view) {
		views.push(view);
		view.measure(target.getWidth(), target.getHeight());
		view.layout(0, 0);
		paint();
	}

	public void backward() {
		if (views.size() == 1) {
			target.shutdown();
			return;
		}
		views.pop();
		paint();
	}

	private void paint() {
		backView.paint(palette);
		views.peek().paint(palette);
	}

	private class MotionDispatcher implements IMotionDispatcher {
		@Override
		public boolean dispatchMotionEvent(MotionEvent event) {
			if (!views.isEmpty())
				return views.peek().dispatchMotionEvent(event);
			return false;
		}
	}
}
