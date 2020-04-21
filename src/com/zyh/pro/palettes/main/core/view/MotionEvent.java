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
		return "MotionEvent(" + x + ", " + y + ")";
	}

	public enum MotionType {
		DOWN {
			@Override
			protected boolean isConsumed(MotionCallback motionCallback, MotionEvent event) {
				return motionCallback.motionDown(event);
			}
		}, UP {
			@Override
			protected boolean isConsumed(MotionCallback motionCallback, MotionEvent event) {
				return motionCallback.motionUp(event);
			}
		}, MOVE {
			@Override
			protected boolean isConsumed(MotionCallback motionCallback, MotionEvent event) {
				return motionCallback.motionMove(event);
			}
		};

		public final boolean onMotion(MotionEvent event, MotionCallback motionCallback) {
			if (isConsumed(motionCallback, event)) {
				toCache(event);
				return true;
			}
			return false;
		}

		protected abstract boolean isConsumed(MotionCallback motionCallback, MotionEvent event);
	}

	public interface MotionCallback {
		boolean motionUp(MotionEvent event);

		boolean motionDown(MotionEvent event);

		boolean motionMove(MotionEvent event);
	}
}
