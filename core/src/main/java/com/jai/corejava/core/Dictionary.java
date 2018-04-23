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
			// Copies to new array
			System.arraycopy(keys, 0, newKeys, 0, keys.length);
			System.arraycopy(values, 0, newValues, 0, values.length);
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

	String equiv(String keyInput) throws NotFoundException {
		int index = 0;
		for (String key : keys) {
			if (key != null && key.equalsIgnoreCase(keyInput)) {
				return values[index];
			}
			index++;
		}
		return null;
	}

	void remove(String keyInput) throws NotFoundException {

		int index = 0;
		String[] newKeys = new String[keys.length - 1];
		String[] newValues = new String[keys.length - 1];

		for (String key : keys) {
			if (keyInput.equalsIgnoreCase(key)) {
				keys[index] = null;
				values[index] = null;
			}
			System.arraycopy(keys, 0, newKeys, 0, keys.length);
			System.arraycopy(values, 0, newValues, 0, values.length);

			index++;
		}
	}

	boolean same(String key, String value) throws NotFoundException {
		boolean same = false;
		int index = 0;
		for (String keyValue : keys) {
			if (key.equalsIgnoreCase(keyValue)) {
				value.equalsIgnoreCase(values[index]);
				return true;
			}
			index++;
		}
		return same;
	}

	int size() {
		return keys.length;
	}

}
