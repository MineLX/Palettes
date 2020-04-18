package com.zyh.pro.palettes.main;

import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.ToIntFunction;

public class LinearLayoutMeasure {

	private final LinearLayout layout;

	private final int specParam;


	private final Function<View, IntConsumer> measurerGetter;

	private final ToIntFunction<View> boundSizeGetter;


	private final IntConsumer sizeSetter;

	private final IntSupplier sizeGetter;

	// FIXME 2020/4/18  wait for me!!!   to be subclass of MeasureSpec if must
	LinearLayoutMeasure(LinearLayout layout, int specParam, Function<View, IntConsumer> measurerGetter,
	                    ToIntFunction<View> boundSizeGetter, IntConsumer sizeSetter, IntSupplier sizeGetter) {
		this.layout = layout;
		this.specParam = specParam;
		this.measurerGetter = measurerGetter;
		this.boundSizeGetter = boundSizeGetter;
		this.sizeSetter = sizeSetter;
		this.sizeGetter = sizeGetter;
	}

	protected void measure(int remainder) {
		if (isWrap()) {
			onWrap(remainder);
			return;
		}
		onOther();
	}

	private void onOther() {
		for (View child : layout.getChildren())
			measureChildWith(sizeGetter.getAsInt(), child);
	}

	private void onWrap(int remainder) {
		for (View child : layout.getChildren())
			measureChildWith(remainder, child);

		int newSize = layout.getChildren().stream().mapToInt(boundSizeGetter).reduce(0, Integer::sum);
		int result = Math.min(newSize, remainder) - (layout.getParams().getMargin() * 2);

		sizeSetter.accept(result);
	}

	private void measureChildWith(int remainder, View child) {
		measurerGetter.apply(child).accept(remainder);
	}

	private boolean isWrap() {
		return specParam == MeasureSpec.WRAP_CONTENT;
	}
}
