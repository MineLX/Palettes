package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.ReflectObject;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReflectObjectTest {
	public static class A {
		int value;

		int value2;

		int value3;

		public void setValue2(int value2) {
			this.value2 = value2;
		}

		public void setValue3(int value3) {
			this.value3 = value3;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}

	@Test
	public void edge_set_non_exist_field() {
		A a = new A();
		ReflectObject object = new ReflectObject(a);
		object.set("nonExist", "nonExist");
		object.set("value", 666);
		assertThat(a.value, is(666));
	}

	@Test
	public void setWith() {
		A a = new A();
		ReflectObject object = new ReflectObject(a);
		HashMap<String, Object> map = new HashMap<>();
		map.put("value", 1);
		map.put("value2", 2);
		map.put("value3", 3);
		object.setWith(map);
		assertThat(a.value, is(1));
		assertThat(a.value2, is(2));
		assertThat(a.value3, is(3));
	}

	@Test
	public void set() {
		A a = new A();
		ReflectObject object = new ReflectObject(a);
		object.set("value", 666);
		assertThat(a.value, is(666));
	}
}
