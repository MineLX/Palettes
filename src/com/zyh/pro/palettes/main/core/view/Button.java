package com.zyh.pro.palettes.main.core.view;

import com.zyh.pro.palettes.main.core.IPalette;
import com.zyh.pro.palettes.main.core.view.ClickListener.OnClickListener;

import java.util.Map;

public class Button extends View {

	private final ClickListener clickListener;

	public Button(Map<String, String> attributes) {
		super(attributes);
		clickListener = new ClickListener();
	}

	public void setOnClickListener(OnClickListener onClickListener) {
		clickListener.setOnClickListener(onClickListener);
	}

	@Override
	protected void onViewDraw(IPalette palette) {
		palette.clear(0x660077);
	}

	@Override
	public boolean dispatchMotionEvent(MotionEvent event) {
		clickListener.dispatchMotionEvent(event);
		return super.dispatchMotionEvent(event);
	}
}
