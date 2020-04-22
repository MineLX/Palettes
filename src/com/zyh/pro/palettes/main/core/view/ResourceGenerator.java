package com.zyh.pro.palettes.main.core.view;

import com.zyh.pro.dotjavabuilder.main.DotClass;
import com.zyh.pro.dotjavabuilder.main.DotField;
import com.zyh.pro.dotjavabuilder.main.Modifiers;
import com.zyh.pro.palettes.test.Files;
import com.zyh.pro.xmlparser.main.XMLNode;
import com.zyh.pro.xmlparser.main.XMLParser;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResourceGenerator {

	private static final String TYPE_OF_FIELD = "String";

	private static final String CLASS_NAME = "R";

	private final List<String> xmlPaths;

	public ResourceGenerator() {
		xmlPaths = new ArrayList<>();
	}

	public void generate(PrintStream printStream) throws FileNotFoundException {
		printStream.print(makeFileContent(findAllID()));
	}

	public List<String> findId(String xmlPath) throws FileNotFoundException {
		List<XMLNode> flatNodes = new XMLParser().parse(Files.toString(xmlPath)).toList();

		return flatNodes.stream()
				.map(XMLNode::getProperties)
				.filter(properties -> properties.containsKey("id"))
				.map(properties -> properties.get("id")).collect(Collectors.toList());
	}

	public void addPath(String xmlPath) {
		xmlPaths.add(xmlPath);
	}

	private String makeFileContent(List<String> allId) {
		DotClass dotClass = getDotClass();

		allId.stream().map(this::createFieldById)
				.forEach(dotClass::add);

//		for (int count = 0; count < allId.size(); count++) {
//			DotField field = new DotField(getFieldModifier(), TYPE_OF_FIELD, allId.get(count));
//			field.setInitValue(valueOf(count));
//			dotClass.add(field);
//		}
		return dotClass.toPlainText();
	}

	private DotField createFieldById(String id) {
		DotField result = new DotField(getFieldModifier(), TYPE_OF_FIELD, id);
		result.setInitValue("\"" + id + "\"");
		return result;
	}

	private List<String> findAllID() throws FileNotFoundException {
		List<String> result = new ArrayList<>();
		for (String xmlPath : xmlPaths)
			result.addAll(findId(xmlPath));
		return result;
	}

	private DotClass getDotClass() {
		Modifiers modifiers = new Modifiers();
		modifiers.toPublic();
		modifiers.toFinal();
		return new DotClass(modifiers, CLASS_NAME);
	}

	private Modifiers getFieldModifier() {
		Modifiers fieldModifier = new Modifiers();
		fieldModifier.toPublic();
		fieldModifier.toFinal();
		fieldModifier.toStatic();
		return fieldModifier;
	}
}
