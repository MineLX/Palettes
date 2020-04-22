package com.zyh.pro.palettes.main.core.view;

import static java.lang.Math.abs;
import static java.lang.System.currentTimeMillis;

public class ClickListener implements MotionDispatcher, MotionEvent.MotionListener {

	private static final int COORDINATE_RANGE = 50;

	private static final int INTERVAL = 250;

	private OnClickListener onClickListener;

	private long downMillis;

	private int downX;

	private int downY;

	@Override
	public boolean motionDown(MotionEvent event) {
		downMillis = currentTimeMillis();
		downX = event.getX();
		downY = event.getY();
		return true;
	}

	@Override
	public boolean motionUp(MotionEvent event) {
		if (outOfTimeMillis()
				|| outOfRange(event.getY(), downY)
				|| outOfRange(event.getX(), downX))
			return true;
		if (onClickListener != null)
			onClickListener.onClick(event);
		return true;
	}

	@Override
	public boolean motionMove(MotionEvent event) {
		return true;
	}

	private boolean outOfRange(int up, int down) {
		return abs(up - down) > COORDINATE_RANGE;
	}

	private boolean outOfTimeMillis() {
		return currentTimeMillis() > downMillis + INTERVAL;
	}

	@Override
	public boolean dispatchMotionEvent(MotionEvent event) {
		return event.getType().consume(this, event);
	}

	public void setOnClickListener(OnClickListener onClickListener) {
		this.onClickListener = onClickListener;
	}

	public interface OnClickListener {
		void onClick(MotionEvent event);
	}
}
