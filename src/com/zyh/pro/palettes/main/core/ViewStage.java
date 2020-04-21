package com.zyh.pro.palettes.main.core;

import com.zyh.pro.palettes.main.core.view.View;
import com.zyh.pro.palettes.main.core.view.ViewGroup;

import java.util.HashMap;

public class ViewStage extends RoleStage {

	private final ViewGroup viewRoot;

	public ViewStage(IPalettesFactory factory, int backgroundValue) {
		super(factory, backgroundValue);

		viewRoot = createViewRoot();
		relayout();
		getRoot().addRole(viewRoot);
	}

	private ViewGroup createViewRoot() {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put("widthSpec", "-1");
		attributes.put("heightSpec", "-1");
		return new ViewGroup(attributes);
	}

	private void relayout() {
		viewRoot.measure(getTarget().getWidth(), getTarget().getHeight());
		viewRoot.layout(0, 0);
	}

	public void addView(View view) {
		viewRoot.addChild(view);
		relayout();
	}
}
