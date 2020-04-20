package com.zyh.pro.palettes.main.common.charmap;

public class StringCharArrayTransformer implements ITransformer<String, char[][]> {
	@Override
	public char[][] forward(String asText) {
		String[] lines = asText.split("\r\n");
		char[][] result = new char[lines.length][lines[0].length()];
		for (int h = 0; h < lines.length; h++) {
			String line = lines[h];
			for (int w = 0; w < lines[0].length(); w++) {
				result[h][w] = line.charAt(w);
			}
		}
		return result;
	}

	@Override
	public String backward(char[][] source) {
		StringBuilder result = new StringBuilder();
		for (char[] chars : source) {
			for (int w = 0; w < source[0].length; w++) {
				result.append(chars[w]);
			}
			result.append("\r\n");
		}
		return result.toString();
	}
}
