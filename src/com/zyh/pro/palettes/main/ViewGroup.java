package com.zyh.pro.palettes.main;

import java.util.ArrayList;
import java.util.List;

public class ViewGroup extends View {

	private final List<View> children;

	public ViewGroup() {
		children = new ArrayList<>();
	}

	@Override
	protected final void onViewDraw(IPalette palette) {
		onSelfDraw(palette);
		for (View child : children)
			child.onDraw(palette);
	}

	protected void onSelfDraw(IPalette palette) {
	}

	public void addChild(View child) {
		children.add(child);
	}

	public void setLayout(LinearLayout layout) {

	}
}
