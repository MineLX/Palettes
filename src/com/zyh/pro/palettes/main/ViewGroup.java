package com.zyh.pro.palettes.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ViewGroup extends View {

	private final List<View> children;

	public ViewGroup(Map<String, String> map) {
		super(map);

		children = new ArrayList<>();
	}

	@Override
	protected final void onViewDraw(IPalette palette) {
		onSelfDraw(palette);
		for (View child : children)
			child.onDraw(palette);
	}

	public void addChild(View child) {
		children.add(child);
	}

	protected List<View> getChildren() {
		return children;
	}

	protected void onSelfDraw(IPalette palette) {
	}
}
