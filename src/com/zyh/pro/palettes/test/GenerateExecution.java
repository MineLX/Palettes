package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.view.ResourceGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class GenerateExecution {
	public static void main(String[] args) throws FileNotFoundException {
		ResourceGenerator generator = new ResourceGenerator();
		generator.addPath("/com/zyh/pro/palettes/test/dumped.xml");

		FileOutputStream outputStream = new FileOutputStream(new File("C:\\Users\\Remain\\IdeaProjects\\Palettes\\src\\com\\zyh\\pro\\palettes\\main\\core\\view\\R.java"));
		generator.generate(new PrintStream(outputStream));
	}
}
