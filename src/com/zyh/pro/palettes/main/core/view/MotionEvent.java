package com.zyh.pro.palettes.main.core.view;

import com.zyh.pro.taskscheduler.main.Cache;

public class MotionEvent {

	private static final Cache<MotionEvent> CACHE = new Cache<>(MotionEvent::new);

	private int x;

	private int y;

	private MotionType type;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public MotionType getType() {
		return type;
	}

	private MotionEvent() {
	}

	public static MotionEvent get(MotionType type, int x, int y) {
		MotionEvent result = CACHE.get();
		result.type = type;
		result.x = x;
		result.y = y;
		return result;
	}

	private static void toCache(MotionEvent item) {
		CACHE.add(item);
	}

	@Override
	public String toString() {
		return "MotionEvent(" + type + ", " + x + ", " + y + ")";
	}

	public enum MotionType {
		DOWN {
			@Override
			protected boolean isConsumed(MotionListener motionListener, MotionEvent event) {
				return motionListener.motionDown(event);
			}
		}, UP {
			@Override
			protected boolean isConsumed(MotionListener motionListener, MotionEvent event) {
				return motionListener.motionUp(event);
			}
		}, MOVE {
			@Override
			protected boolean isConsumed(MotionListener motionListener, MotionEvent event) {
				return motionListener.motionMove(event);
			}
		};

		public final boolean onMotion(MotionEvent event, MotionListener motionListener) {
			if (isConsumed(motionListener, event)) {
				toCache(event);
				return true;
			}
			return false;
		}

		protected abstract boolean isConsumed(MotionListener motionListener, MotionEvent event);
	}

	public interface MotionListener {
		boolean motionUp(MotionEvent event);

		boolean motionDown(MotionEvent event);

		boolean motionMove(MotionEvent event);
	}
}
