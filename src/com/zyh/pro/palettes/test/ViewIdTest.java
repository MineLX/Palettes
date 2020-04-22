package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.view.LayoutInflater;
import com.zyh.pro.palettes.main.core.view.View;
import org.junit.Test;

public class ViewIdTest {
	@Test
	public void simple_test() {
		LayoutInflater inflater = new LayoutInflater();
		View inflate = inflater.inflate("<LinearLayout widthSpec=\"30\" heightSpec=\"40\"><RectView id=\"myRectView\"></RectView></LinearLayout>");
//		inflate.findViewById();
		// FIXME 2020/4/22  wait for me!!!
	}
}
