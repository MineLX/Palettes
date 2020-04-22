package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.view.LayoutInflater;
import com.zyh.pro.palettes.main.core.view.View;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ViewIdTest {
	@Test
	public void flatList() throws FileNotFoundException {
		View inflate = new LayoutInflater().inflate(Files.toString("/com/zyh/pro/palettes/test/GenerateClassFileTest_simple_test.xml"));
		assertThat(inflate.flatList().toString(),
				is("[View(0, 0, 0, 0), View(0, 0, 0, 0), View(0, 0, 0, 0), View(0, 0, 0, 0), View(0, 0, 0, 0)]"));
	}

	@Test
	public void forEachView() {
		LayoutInflater inflater = new LayoutInflater();
		View inflate = inflater.inflate("<LinearLayout widthSpec=\"30\" heightSpec=\"40\"><RectView id=\"myRectView\"></RectView></LinearLayout>");

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		inflate.forEach(printStream::print);
		assertThat(new String(outputStream.toByteArray()), is("View(0, 0, 0, 0)View(0, 0, 0, 0)"));
	}

	@Test
	public void findViewById() {
		LayoutInflater inflater = new LayoutInflater();
		View inflate = inflater.inflate("<LinearLayout widthSpec=\"30\" heightSpec=\"40\"><RectView id=\"myRectView\"></RectView></LinearLayout>");
		View view = inflate.findView("myRectView");
		assertThat(view.getId(), is("myRectView"));
	}
}
