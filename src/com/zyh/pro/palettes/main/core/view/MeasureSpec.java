package com.zyh.pro.palettes.main.core.view;

import java.util.ArrayList;
import java.util.List;

public class MeasureSpec {

	private static final int MATCH_PARENT = -1;

	private static final int WRAP_CONTENT = -2;

	private final List<MeasureSpec> children;

	private final MeasureParams measureParams;

	private int measuredValue;

	public MeasureSpec(MeasureParams measureParams) {
		this.measureParams = measureParams;

		children = new ArrayList<>();
	}

	void addChild(MeasureSpec child) {
		children.add(child);
	}

	protected List<MeasureSpec> getChildren() {
		return children;
	}

	public void measure(int remainder) {
		if (isMatchParent()) {
			onMeasureMatchParent(remainder);
		} else if (isWrapContent()) {
			onMeasureWrapContent(remainder);
		} else { // exactly
			onMeasureExactly(remainder);
		}
	}

	protected int getContentSize(int remainder) {
		return 0;
	}

	protected void onMeasureExactly(int remainder) {
		measuredValue = measureParams.getSpecParam();
	}

	protected void onMeasureWrapContent(int remainder) {
		measuredValue = calculateBestSize(remainder, getContentSize(remainder));
	}

	protected void onMeasureMatchParent(int remainder) {
		measuredValue = calculateBestSize(remainder, remainder);
	}

	private int calculateBestSize(int remainderSize, int specifiedSize) {
		if (isOverflow(remainderSize, specifiedSize))
			return remainderSize - allMarginSize();
		return specifiedSize;
	}

	private boolean isOverflow(int remainderSize, int specifiedSize) {
		return specifiedSize + allMarginSize() > remainderSize;
	}

	public final int getBoundSize() {
		return getMeasuredValue() + allMarginSize();
	}

	public int getMeasuredValue() {
		return measuredValue;
	}

	public void setMeasuredValue(int measuredValue) {
		this.measuredValue = measuredValue;
	}

	protected final int allMarginSize() {
		return measureParams.getMargin() * 2;
	}

	private boolean isWrapContent() {
		return measureParams.getSpecParam() == WRAP_CONTENT;
	}

	private boolean isMatchParent() {
		return measureParams.getSpecParam() == MATCH_PARENT;
	}
}
