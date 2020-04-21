package com.zyh.pro.palettes.main.core.view;

import com.zyh.pro.palettes.main.core.IPalette;

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
	protected MeasureSpec createWidthSpec(MeasureParams measureParams) {
		return new LinearLayoutMeasure(
				measureParams);
	}

	@Override
	protected MeasureSpec createHeightSpec(MeasureParams measureParams) {
		return new LinearLayoutMeasure(
				measureParams);
	}

	@Override
	protected void onMeasureWidth(int remainderWidth) {
		measureSelfWidth(remainderWidth);
	}

	@Override
	protected void onMeasureHeight(int remainderHeight) {
		measureSelfHeight(remainderHeight);
	}

	@Override
	protected void onLayout(int recommendedX, int recommendedY) {
		layoutSelf(recommendedX, recommendedY);

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

	@Override
	protected void onGroupDraw(IPalette palette) {
	}
}
