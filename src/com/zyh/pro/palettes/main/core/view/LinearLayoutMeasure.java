package com.zyh.pro.palettes.main.core.view;

public class LinearLayoutMeasure extends MeasureSpec {

	LinearLayoutMeasure(MeasureParams measureParams) {
		super(measureParams);
	}

	@Override
	protected void onMeasureExactly(int remainder) {
		super.onMeasureExactly(remainder);

		measureChildrenBy(getMeasuredValue());
	}

	@Override
	protected void onMeasureMatchParent(int remainder) {
		super.onMeasureMatchParent(remainder);

		measureChildrenBy(getMeasuredValue());
	}

	@Override
	protected void onMeasureWrapContent(int remainder) {
		super.onMeasureWrapContent(remainder);

		measureChildrenBy(remainder);

		int newSize = getChildren().stream()
				.mapToInt(MeasureSpec::getBoundSize)
				.reduce(0, Integer::sum);
		setMeasuredValue(Math.min(newSize, remainder) - allMarginSize());
	}

	private void measureChildrenBy(int measuredValue) {
		for (MeasureSpec child : getChildren())
			child.measure(measuredValue);
	}
}
