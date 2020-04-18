package com.zyh.pro.palettes.main;

import java.util.Map;

import static java.lang.Integer.parseInt;

public class LinearLayout extends ViewGroup {

	public static final int VERTICAL = 0;

	public static final int HORIZONTAL = 1;

	private final int orientation;

	public LinearLayout(Map<String, String> map) {
		super(map);

		orientation = parseInt(map.get("orientation"));
	}

	@Override
	protected void measureHeight(int remainderHeight) {
		super.measureHeight(remainderHeight);

		new LinearLayoutMeasure(this, params.heightSpecParam, view -> view::measureHeight,
				View::getBoundHeight, this::setHeight, this::getHeight).measure(remainderHeight);
	}

	@Override
	protected void measureWidth(int remainderWidth) {
		super.measureWidth(remainderWidth);

		new LinearLayoutMeasure(this, params.widthSpecParam, view -> view::measureWidth,
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
