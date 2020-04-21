package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.view.MeasureParams;
import com.zyh.pro.palettes.main.core.view.MeasureSpec;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MeasureSpecTest {
	@Test
	public void boundSize() {
		MeasureParams params = new MeasureParams(-1, 5);
		MeasureSpec spec = new MeasureSpec(params);
		spec.setMeasuredValue(50);
		assertThat(spec.getBoundSize(), is(50 + 5 * 2));
	}
}
