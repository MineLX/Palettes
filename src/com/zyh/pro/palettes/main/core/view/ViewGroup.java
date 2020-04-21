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

		this.widthSpec.addChild(child.widthSpec);
		this.heightSpec.addChild(child.heightSpec);
	}

	public View getChildAt(int at) {
		return children.get(at);
	}

	protected List<View> getChildren() {
		return children;
	}

	protected void onGroupDraw(IPalette palette) {
		palette.clear(0xffffff);
	}

	@Override
	protected MeasureSpec createWidthSpec(MeasureParams measureParams) {
		return new ViewGroupMeasureSpec(measureParams);
	}

	@Override
	protected MeasureSpec createHeightSpec(MeasureParams measureParams) {
		return new ViewGroupMeasureSpec(measureParams);
	}

	@Override
	protected void onLayout(int recommendedX, int recommendedY) {
		layoutSelf(recommendedX, recommendedY);

		for (View child : children)
			child.layout(recommendedX, recommendedY);
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

	public static class ViewGroupMeasureSpec extends MeasureSpec {
		protected ViewGroupMeasureSpec(MeasureParams measureParams) {
			super(measureParams);
		}

		@Override
		public void measure(int remainder) {
			super.measure(remainder);

			for (MeasureSpec child : getChildren())
				child.measure(remainder);
		}
	}
}
