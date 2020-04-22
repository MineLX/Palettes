package com.zyh.pro.palettes.main.core.view;

import com.zyh.pro.palettes.main.core.IPalette;

import java.util.Map;

public class RectView extends View {

	private final int value;

	public RectView(Map<String, String> attributes, int value) {  // FIXME 2020/4/22  wait for me!!!  attributes and value ?
		super(attributes);

		this.value = value;
	}

	@Override
	protected void onViewDraw(IPalette palette) {
		palette.fillRect(0, 0, getWidth(), getHeight(), value);
	}

	@Override
	protected boolean onMotionMove(MotionEvent event) {
		System.out.println(this + "  RectView event = " + event);
		return super.onMotionMove(event);
	}

	@Override
	protected boolean onMotionUp(MotionEvent event) {
		System.out.println(this + "  RectView event = " + event);
		return super.onMotionUp(event);
	}

	@Override
	protected boolean onMotionDown(MotionEvent event) {
		System.out.println(this + "  RectView event = " + event);
		return super.onMotionDown(event);
	}
}
