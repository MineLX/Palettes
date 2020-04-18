package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.ReflectObject;
import org.junit.Test;

public class ReflectAssignTest {
	static class A {
		int value;

		public void setValue(int value) {
			this.value = value;
		}
	}

	@Test
	public void simple_test(){
		new ReflectObject();
	}
}
