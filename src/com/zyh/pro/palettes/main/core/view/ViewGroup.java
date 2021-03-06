package com.zyh.pro.palettes.main.core.view;

import com.zyh.pro.palettes.main.core.IPalette;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

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

	protected void onGroupDraw(IPalette palette) {
	}

	public void addChild(View child) {
		children.add(child);

		widthSpec.addChild(child.widthSpec);
		heightSpec.addChild(child.heightSpec);
	}

	public View getChildAt(int at) {
		return children.get(at);
	}

	protected List<View> getChildren() {
		return children;
	}

	@Override
	protected MeasureSpec createSpec(MeasureParams measureParams) {
		return new ViewGroupMeasureSpec(measureParams);
	}

	@Override
	public void layout(int recommendedX, int recommendedY) {
		super.layout(recommendedX, recommendedY);

		onLayoutChildren(recommendedX, recommendedY);
	}

	protected void onLayoutChildren(int recommendedX, int recommendedY) {
		for (View child : children)
			child.layout(recommendedX, recommendedY);
	}

	@Override
	public boolean dispatchMotionEvent(MotionEvent event) {
		if (super.dispatchMotionEvent(event))
			return true;

		for (View child : getChildren()) {
			if (child.dispatchMotionEvent(event))
				return true;
		}
		return false;
//		return children.stream().anyMatch(child -> child.dispatchMotionEvent(event));
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

	@Override
	public void forEach(Consumer<View> consumer) {
		super.forEach(consumer);
		for (View child : children)
			child.forEach(consumer);
	}

	@Override
	public View findViewById(String resourceId) {
		if (resourceId.equals(getId())) return this;

		for (View child : children) {
			View view = child.findViewById(resourceId);
			if (view != null)
				return view;
		}
		return null;
	}

	public static class ViewGroupMeasureSpec extends MeasureSpec {

		ViewGroupMeasureSpec(MeasureParams measureParams) {
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
