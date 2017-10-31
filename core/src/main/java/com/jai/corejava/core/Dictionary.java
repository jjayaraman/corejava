package com.jai.corejava.core;

import java.util.Arrays;

public class Dictionary {

	private String[] keys = new String[1];
	private String[] values = new String[1];

	int index = 0;

	void add(String word1, String word2) {
		System.out.println("len : " + index);
		try {
			keys[index] = word1;
			values[index] = word2;
		}
		catch (ArrayIndexOutOfBoundsException e) {
			int newLength = keys.length + 1;
			String[] newKeys = new String[newLength];
			String[] newValues = new String[newLength];
			System.arraycopy(keys, 0, newKeys, 0, 1);
			System.arraycopy(values, 0, newValues, 0, 1);
			keys = newKeys;
			values = newValues;
			keys[index] = word1;
			values[index] = word2;
		}
		index++;
		System.out.println(Arrays.toString(keys));
	}

	boolean contains(String word) {
		boolean contains = false;
		for (String value : values) {
			if (value.equalsIgnoreCase(word)) {
				contains = true;
				return true;
			}
		}
		return contains;
	}

	String equiv(String word) throws NotFoundException {
		int index = 0;
		for (String key : keys) {
			if (key != null && key.equalsIgnoreCase(word)) {
				return values[index];
			}
			index++;
		}
		return null;
	}

	void remove(String word) throws NotFoundException {

	}

	boolean same(String word1, String word2) throws NotFoundException {
		boolean same = false;

		return same;

	}

	int size() {
		return keys.length;
	}

}
