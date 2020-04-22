package com.zyh.pro.palettes.main.core.view;

import com.zyh.pro.xmlparser.main.XMLNode;
import com.zyh.pro.xmlparser.main.XMLParser;

public class LayoutInflater {

	public View inflate(String source) {
		XMLNode parsed = new XMLParser().parse(source);
		return parsed.convertWithLeaf(this::createGroupView, this::createView, ViewGroup::addChild);
	}

	private ViewGroup createGroupView(XMLNode groupNode) {
		return (ViewGroup) createView(groupNode);
	}

	private View createView(XMLNode xmlNode) { // FIXME 2020/4/20  wait for me!!!  file for adaptation
		if (xmlNode.getTag().equals("LinearLayout"))
			return new LinearLayout(xmlNode.getProperties());
		if (xmlNode.getTag().equals("RectView"))
			return new RectView(xmlNode.getProperties(), 0xff00ff);
		if (xmlNode.getTag().equals("Button"))
			return new Button(xmlNode.getProperties());

		throw new IllegalArgumentException("specified viewName is not found.");
	}
}
