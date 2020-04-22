package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.view.ResourceGenerator;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GenerateClassFileTest {
	@Test
	public void generate() throws FileNotFoundException {
		ResourceGenerator generator = new ResourceGenerator();
		generator.addPath("/com/zyh/pro/palettes/test/GenerateClassFileTest_simple_test.xml");

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		generator.generate(new PrintStream(outputStream));
		assertThat(new String(outputStream.toByteArray()), is("public final class R{public static final String myRectId=\"myRectId\";}"));
	}

	@Test
	public void findId() throws FileNotFoundException {
		ResourceGenerator generator = new ResourceGenerator();
		assertThat(generator.findId("/com/zyh/pro/palettes/test/GenerateClassFileTest_simple_test.xml").toString(),
				is("[myRectId]"));
	}
}
