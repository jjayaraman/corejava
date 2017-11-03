package com.jai.corejava.core;

import java.util.Arrays;

import junit.framework.TestCase;

public class DictionaryTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testHello() {

		Dictionary dict = new Dictionary();
		String module;
		dict.add("ECS510", "ADSOOF");
		dict.add("ECS414", "OOP");
		dict.add("ECS505", "Software Engineering");
		dict.add("ECS607", "Data Mining");
		System.out.println("Number of modules is: " + dict.size());
		try {
			module = dict.equiv("ECS505");
			System.out.println("The module with code ECS505 is: " + module);
			if (dict.contains("ECS410")) {
				module = dict.equiv("ECS410");
				System.out.println("The module with code ECS410 is: " + module);
			}
			else
				System.out.println("There is no module with code ECS410");
			if (dict.same("ECS414", "OOP"))
				System.out.println("The module with code ECS414 is: OOP");
			else
				System.out.println("The module with code ECS414 is not OOP");
			dict.remove("ECS510");
			module = dict.equiv("ECS510");
			System.out.println("The module with code ECS510 is: " + module);
		}
		catch (NotFoundException e) {
			module = e.getMessage();
			System.out.println("There is no module with code " + module);
		}

	}

	// Test to understand how System.arraycopy() works
	public void testArrayCopy() {

		String[] source = new String[] { "one", "two", "three", "four", "five" };
		String[] dest = new String[] { "1", "2", "3", "4", "5" };

		System.arraycopy(source, 0, dest, 0, 3);

		System.out.println(Arrays.toString(source));
		System.out.println(Arrays.toString(dest));
	}

}
