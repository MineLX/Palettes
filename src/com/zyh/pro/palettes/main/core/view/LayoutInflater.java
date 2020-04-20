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

		System.out.println("specified viewName is not found.");
		return new View(null);
	}
}
