package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.*;
import com.zyh.pro.palettes.main.core.view.*;

import javax.smartcardio.ATR;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class ViewStageTest {
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		viewStage();
	}

	private static void viewStage() throws FileNotFoundException, InterruptedException {
		ViewNavigator navigator = new ViewNavigator(new AwtPalettesFactory(1000, 600));
		View inflate = new LayoutInflater()
				.inflate(Files.toString("C:\\Users\\Remain\\IdeaProjects\\Palettes\\src\\com\\zyh\\pro\\palettes\\test\\dumped.xml"));
		navigator.forward(inflate);

		Thread.sleep(4000);
		Map<String, String> attributes = new HashMap<>();
		attributes.put("widthSpec", "400");
		attributes.put("heightSpec", "-1");
		RectView rectView = new RectView(attributes, 0);
		navigator.forward(rectView);

		Thread.sleep(4000);
		navigator.backward();

		Thread.sleep(4000);
		navigator.backward();
	}
}
