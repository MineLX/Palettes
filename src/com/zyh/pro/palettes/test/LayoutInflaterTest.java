package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.view.LayoutInflater;
import com.zyh.pro.palettes.main.core.view.RectView;
import com.zyh.pro.palettes.main.core.view.View;
import com.zyh.pro.palettes.main.core.view.ViewGroup;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LayoutInflaterTest {
	@Test
	public void multi_level_inflation() throws FileNotFoundException {
		ViewGroup inflated = (ViewGroup) new LayoutInflater().inflate(Files.toString("C:\\Users\\Remain\\Desktop\\dumped.xml"));

		verifyParams(inflated.getParams(), -1, -1, 0);

		RectView view = (RectView) inflated.getChildAt(0);
		verifyParams(view.getParams(), -1, 40, 5);

		RectView view2 = (RectView) inflated.getChildAt(1);
		verifyParams(view2.getParams(), -1, 40, 5);

		RectView view3 = (RectView) inflated.getChildAt(2);
		verifyParams(view3.getParams(), -1, 60, 2);
	}

	@Test
	public void inflate_singleView(){
		View inflated = new LayoutInflater().inflate("<LinearLayout widthSpec=\"30\" heightSpec=\"40\"></LinearLayout>");
		View.Params params = inflated.getParams();
		verifyParams(params, 30, 40, 0);
	}

	private void verifyParams(View.Params params, int widthSpec, int heightSpec, int margin) {
		assertThat(params.getWidthSpec(), is(widthSpec));
		assertThat(params.getHeightSpec(), is(heightSpec));
		assertThat(params.getMargin(), is(margin));
	}
}
