package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.Stage;
import com.zyh.pro.palettes.main.core.AwtPalettesFactory;
import com.zyh.pro.palettes.main.core.role.TestRole;

public class GraphStageTest {
	public static void main(String[] args) {
		Stage stage = new Stage(new AwtPalettesFactory(1000, 600), 0);
		stage.addRole(new TestRole(stage.getTarget()));
	}
}
