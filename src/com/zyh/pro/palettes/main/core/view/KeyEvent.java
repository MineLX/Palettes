package com.zyh.pro.palettes.main.core.view;

import com.zyh.pro.taskscheduler.main.Cache;

public class KeyEvent { // FIXME 2020/4/20  wait for me!!!  jframes' events handler is single-thread.  cache can be removed.

	private static final Cache<KeyEvent> CACHE = new Cache<>(KeyEvent::new);

	private int keyCode;

	public static KeyEvent get(int keyCode) {
		KeyEvent event = CACHE.get();
		event.keyCode = keyCode;
		return event;
	}

	public int getKeyCode() {
		return keyCode;
	}

	public interface KeyListener { // FIXME 2020/4/20  wait for me!!!  to abstractClass if must
		default void down(KeyEvent keyEvent) {
			onDown(keyEvent);
			CACHE.add(keyEvent);
		}

		default void up(KeyEvent keyEvent) {
			onUp(keyEvent);
			CACHE.add(keyEvent);
		}

		void onDown(KeyEvent keyEvent);

		void onUp(KeyEvent keyEvent);
	}
}
