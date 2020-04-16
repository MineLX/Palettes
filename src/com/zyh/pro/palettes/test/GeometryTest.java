package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.Oval;
import com.zyh.pro.palettes.main.Point;
import com.zyh.pro.palettes.main.Rect;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GeometryTest {

	@Test
	public void oval_rotate() {
		Oval oval = new Oval(2, 0, 5, 5);
		oval.rotate(0, 0, 90);
		assertThat(oval, is(new Oval(0, 2, 5, 5)));
	}

	@Test
	public void equals() {
		assertThat(new Oval(0, 0, 0, 0),
				is(new Oval(0, 0, 0, 0)));
		assertThat(new Point(0, 0),
				is(new Point(0, 0)));
		assertThat(new Rect(0, 0, 0, 0),
				is(new Rect(0, 0, 0, 0)));
	}
}
