package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.view.MotionEvent;
import org.junit.Test;

import static com.zyh.pro.palettes.main.core.view.MotionEvent.*;
import static com.zyh.pro.palettes.main.core.view.MotionEvent.MotionType.DOWN;
import static com.zyh.pro.palettes.main.core.view.MotionEvent.MotionType.UP;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MotionEventTest {

	@Test
	public void type_of_Event() {
		assertThat(get(DOWN, 0, 0).getType(), is(DOWN));
		assertThat(get(UP, 0, 0).getType(), is(UP));
	}

	@Test
	public void getX_Y(){
		MotionEvent event = get(DOWN, 50, 30);
		assertThat(event.getX(), is(50));
		assertThat(event.getY(), is(30));
	}
}
