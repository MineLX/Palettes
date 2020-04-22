package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.view.Pointer;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PointerTest {
	@Test
	public void simple_test() {
		Pointer pointer = new Pointer();
		assertThat(pointer.down(), is(true));
		assertThat(pointer.down(), is(false));
		assertThat(pointer.move(), is(true));
		assertThat(pointer.up(), is(true));

		assertThat(pointer.move(), is(false));
		assertThat(pointer.up(), is(false));
	}

	@Test
	public void multiDown() {
		Pointer pointer = new Pointer();
		assertThat(pointer.down(), is(true));
		assertThat(pointer.down(), is(false));
		assertThat(pointer.move(), is(true));
		assertThat(pointer.up(), is(true));

		assertThat(pointer.down(), is(true));
		assertThat(pointer.move(), is(true));
		assertThat(pointer.up(), is(true));
		assertThat(pointer.up(), is(false));
		assertThat(pointer.move(), is(false));
	}
}
