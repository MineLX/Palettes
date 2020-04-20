package com.zyh.pro.palettes.main.core.view;

import java.util.Map;

import static java.lang.Integer.parseInt;

public class LinearLayout extends ViewGroup {

	public static final int VERTICAL = 0;

	public static final int HORIZONTAL = 1;

	private final int orientation;

	public LinearLayout(Map<String, String> attributes) {
		super(attributes);

		String orientationAsText = attributes.get("orientation");
		orientation = orientationAsText != null ? parseInt(orientationAsText) : VERTICAL;
	}

	@Override
	protected void onMeasureHeight(int remainderHeight) {
		super.onMeasureHeight(remainderHeight);

		new LinearLayoutMeasure(this, getParams().getHeightSpec(), view -> view::onMeasureHeight,
				View::getBoundHeight, this::setHeight, this::getHeight).measure(remainderHeight);
	}

	@Override
	protected void onMeasureWidth(int remainderWidth) {
		super.onMeasureWidth(remainderWidth);

		new LinearLayoutMeasure(this, getParams().getWidthSpec(), view -> view::onMeasureWidth,
				View::getBoundWidth, this::setWidth, this::getWidth).measure(remainderWidth);
	}

	@Override
	public void layout(int recommendedX, int recommendedY) {
		super.layout(recommendedX, recommendedY);

		int used = 0;
		for (View child : getChildren())
			used += layoutChild(child, used) + 1;
	}

	private int layoutChild(View child, int progress) {
		if (orientation == HORIZONTAL) {
			child.layout(progress, 0);
			return child.getBoundWidth();
		} else {
			child.layout(0, progress);
			return child.getBoundHeight();
		}
	}
}
