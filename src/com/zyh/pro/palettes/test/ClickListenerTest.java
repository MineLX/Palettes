package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.view.ClickListener;
import com.zyh.pro.palettes.main.core.view.MotionEvent;
import com.zyh.pro.taskscheduler.main.CallbackTask;
import org.junit.Test;

import static com.zyh.pro.palettes.main.core.view.MotionEvent.MotionType.*;
import static com.zyh.pro.palettes.main.core.view.MotionEvent.get;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ClickListenerTest {
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
