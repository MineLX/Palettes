package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.*;

import java.util.HashMap;

public class ViewTest {
	public static void main(String[] args) {
		Stage stage = new Stage(new D2DPaletteFactory(),
				1000, 600, 0);

		ViewGroup viewGroup = new ClearGroup(new HashMap<>(), 0xff0000);
		viewGroup.setBound(20, 20, 100, 100);

		RectView rectView = new RectView(new HashMap<>());
		rectView.setBound(10, 10, 50, 50);
		viewGroup.addChild(rectView);

		stage.addRole(viewGroup);
	}
}
