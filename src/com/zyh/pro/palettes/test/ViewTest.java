package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.D2DPalettesFactory;
import com.zyh.pro.palettes.main.core.Stage;
import com.zyh.pro.palettes.main.core.view.LayoutInflater;
import com.zyh.pro.palettes.main.core.view.LinearLayout;
import com.zyh.pro.palettes.main.core.view.RectView;
import com.zyh.pro.palettes.main.core.view.ViewGroup;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class ViewTest {

	public static void main(String[] args) throws FileNotFoundException {
		Stage stage = new Stage(new D2DPalettesFactory(1000, 600),
				0);

		ViewGroup group = getLayoutByInflation();
		group.measure(1000, 600);
		group.layout(0, 0);
		stage.addRole(group);
	}

	private static ViewGroup getLayoutByInflation() throws FileNotFoundException {
		return (ViewGroup) new LayoutInflater().inflate(Files.toString("C:\\Users\\Remain\\IdeaProjects\\Palettes\\src\\com\\zyh\\pro\\palettes\\test\\dumped.xml"));
	}

	private static ViewGroup getLayout() {
		HashMap<String, String> groupAttributes = new HashMap<>();
		LinearLayout group = new LinearLayout(groupAttributes);

		HashMap<String, String> attributes = new HashMap<>();
		attributes.put("widthSpec", "-1");
		attributes.put("heightSpec", "100");
		attributes.put("margin", "10");
		RectView rectView = new RectView(attributes, 0xff00ff);
		group.addChild(rectView);
		return group;
	}
}
