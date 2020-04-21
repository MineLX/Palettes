package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.view.MeasureParams;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MeasureParamsTest {
	@Test
	public void simple_test() {
		int specParam = -1;
		int margin = 5;
		MeasureParams params = new MeasureParams(specParam, margin);
		assertThat(params.getSpecParam(), is(specParam));
		assertThat(params.getMargin(), is(margin));
	}
}
