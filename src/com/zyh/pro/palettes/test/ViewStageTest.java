package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.AwtPalettesFactory;
import com.zyh.pro.palettes.main.core.D2DPalettesFactory;
import com.zyh.pro.palettes.main.core.ViewStage;
import com.zyh.pro.palettes.main.core.role.LineRole;
import com.zyh.pro.palettes.main.core.view.LayoutInflater;
import com.zyh.pro.palettes.main.core.view.View;

import java.io.FileNotFoundException;

public class ViewStageTest {
	public static void main(String[] args) throws FileNotFoundException {
		ViewStage stage = new ViewStage(new D2DPalettesFactory(1000, 600), 0);
		stage.addRole(new LineRole(0, 0, 1000, 600, 0xff0000));

		View inflate = new LayoutInflater().inflate(Files.toString("C:\\Users\\Remain\\Desktop\\dumped.xml"));
		stage.addView(inflate);
	}
}
