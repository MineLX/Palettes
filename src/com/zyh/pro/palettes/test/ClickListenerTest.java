package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.view.ClickListener;
import com.zyh.pro.palettes.main.core.view.MotionEvent;
import com.zyh.pro.palettes.main.core.view.View;
import com.zyh.pro.taskscheduler.main.CallbackTask;
import org.junit.Test;

import java.util.HashMap;

import static com.zyh.pro.palettes.main.core.view.MotionEvent.MotionType.*;
import static com.zyh.pro.palettes.main.core.view.MotionEvent.get;

public class ClickListenerTest {
	@Test
	public void with_view() throws InterruptedException {
		CallbackTask task = new CallbackTask(2);

		View view = new View(new HashMap<>()) {
			@Override
			protected boolean onMotionDown(MotionEvent event) {
				task.done();
				return super.onMotionDown(event);
			}
		};
		view.measure(50, 50);
		view.layout(0, 0);
		view.setMotionDispatchListener(event -> {
			task.done();
			return false;
		});
		view.dispatchMotionEvent(get(DOWN, 0, 0));

		task.waitForCompletion();
	}

	@Test
	public void without_listener() {
		ClickListener listener = new ClickListener();
		listener.dispatchMotionEvent(get(DOWN, 0, 0));
		listener.dispatchMotionEvent(get(UP, 0, 0));
	}

	@Test
	public void simple_test() throws InterruptedException {
		CallbackTask task = new CallbackTask();

		ClickListener.OnClickListener onClickListener = event -> task.done();
		ClickListener listener = new ClickListener();

		listener.setOnClickListener(onClickListener);

		listener.dispatchMotionEvent(get(DOWN, 0, 0));
		listener.dispatchMotionEvent(get(UP, 51, 51));

		listener.dispatchMotionEvent(get(DOWN, 0, 0));
		listener.dispatchMotionEvent(get(MOVE, 0, 0));
		listener.dispatchMotionEvent(get(UP, 50, 50));

		task.waitForCompletion();
	}

}
