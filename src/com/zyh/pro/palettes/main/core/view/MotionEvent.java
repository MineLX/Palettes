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

	public static MotionEvent get(MotionType type, int x, int y) { // FIXME 2020/4/22  wait for me!!!  change signature if must
		MotionEvent result = CACHE.get();
		result.type = type;
		result.x = x;
		result.y = y;
		return result;
	}

	public static void toCache(MotionEvent item) {
		CACHE.add(item);
	}

	@Override
	public String toString() {
		return "MotionEvent(" + type + ", " + x + ", " + y + ")";
	}

	public enum MotionType {
		DOWN {
			@Override
			public boolean consume(MotionListener motionListener, MotionEvent event) {
				return motionListener.motionDown(event);
			}
		}, UP {
			@Override
			public boolean consume(MotionListener motionListener, MotionEvent event) {
				return motionListener.motionUp(event);
			}
		}, MOVE {
			@Override
			public boolean consume(MotionListener motionListener, MotionEvent event) {
				return motionListener.motionMove(event);
			}
		};

		public final boolean toCacheIfConsumed(MotionListener motionListener, MotionEvent event) {
			if (consume(motionListener, event)) {
				toCache(event);
				return true;
			}
			return false;
		}

		public abstract boolean consume(MotionListener motionListener, MotionEvent event);
	}

	public interface MotionListener {
		boolean motionUp(MotionEvent event);

		boolean motionDown(MotionEvent event);

		boolean motionMove(MotionEvent event);
	}
}
