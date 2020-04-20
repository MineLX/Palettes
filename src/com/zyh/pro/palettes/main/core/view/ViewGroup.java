package com.zyh.pro.palettes.main.core.view;

import com.zyh.pro.palettes.main.core.IPalette;

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
		onGroupDraw(palette);
		for (View child : children)
			child.onDraw(palette);
	}

	public void addChild(View child) {
		children.add(child);
	}

	public View getChildAt(int at) {
		return children.get(at);
	}

	protected List<View> getChildren() {
		return children;
	}

	protected void onGroupDraw(IPalette palette) {
	}

	@Override
	public boolean dispatchMotionEvent(MotionEvent event) {
		if (super.dispatchMotionEvent(event))
			return true;

		return children.stream().anyMatch(child -> child.dispatchMotionEvent(event));
	}

	@Override
	protected boolean onMotionDown(MotionEvent event) {
		return false;
	}

	@Override
	protected boolean onMotionUp(MotionEvent event) {
		return false;
	}

	@Override
	protected boolean onMotionMove(MotionEvent event) {
		return false;
	}
}
