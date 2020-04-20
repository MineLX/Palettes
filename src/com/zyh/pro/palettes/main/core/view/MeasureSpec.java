package com.zyh.pro.palettes.main.core.view;

public class MeasureSpec {

	static final int MATCH_PARENT = -1;

	static final int WRAP_CONTENT = -2;

	private final View.Params params;

	MeasureSpec(View.Params params) {
		this.params = params;
	}

	int measure(int remainder, int contentSize, int specParam) {
		if (specParam == MATCH_PARENT) {
			return calculateBestSize(remainder, remainder);
		} else if (specParam == WRAP_CONTENT) {
			return calculateBestSize(remainder, contentSize);
		} else { // exactly
			return specParam;
		}
	}

	private int calculateBestSize(int remainderSize, int specifiedSize) {
		if (isOverflow(remainderSize, specifiedSize))
			return remainderSize - allMarginSize();
		return specifiedSize;
	}

	private boolean isOverflow(int remainderSize, int specifiedSize) {
		return specifiedSize + allMarginSize() > remainderSize;
	}

	private int allMarginSize() {
		return params.getMargin() * 2;
	}
}
