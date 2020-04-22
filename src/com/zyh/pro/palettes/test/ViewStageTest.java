package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.D2DPalettesFactory;
import com.zyh.pro.palettes.main.core.ViewNavigator;
import com.zyh.pro.palettes.main.core.view.Button;
import com.zyh.pro.palettes.main.core.view.LayoutInflater;
import com.zyh.pro.palettes.main.core.view.R;
import com.zyh.pro.palettes.main.core.view.View;

import java.io.FileNotFoundException;

public class ViewStageTest {
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		viewStage();
	}

	private static void viewStage() throws FileNotFoundException, InterruptedException {
		ViewNavigator navigator = new ViewNavigator(new D2DPalettesFactory(1000, 600));
		View inflate = new LayoutInflater()
				.inflate(Files.toString("C:\\Users\\Remain\\IdeaProjects\\Palettes\\src\\com\\zyh\\pro\\palettes\\test\\dumped.xml"));
		navigator.forward(inflate);

		Button myButton = inflate.findView(R.myButton);
		myButton.setOnClickListener(event -> System.out.println("onClick event = " + event));

//		Thread.sleep(4000);
//		Map<String, String> attributes = new HashMap<>();
//		attributes.put("widthSpec", "400");
//		attributes.put("heightSpec", "-1");
//		RectView rectView = new RectView(attributes, 0xff0000);
//		navigator.forward(rectView);

//		Thread.sleep(4000);
//		navigator.backward();
//
//		Thread.sleep(4000);
//		navigator.backward();
	}
}
