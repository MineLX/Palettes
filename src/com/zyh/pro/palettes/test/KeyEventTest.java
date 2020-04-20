package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.view.KeyEvent;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class KeyEventTest {
	@Test
	public void simple_test() {
		KeyEvent event = KeyEvent.get(1);
		assertThat(event.getKeyCode(), is(1));
	}
}
