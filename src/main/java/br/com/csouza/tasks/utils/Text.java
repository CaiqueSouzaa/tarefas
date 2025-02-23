package br.com.csouza.tasks.utils;

import java.util.Random;

public class Text {
	private static String letters = "abcdefghijklmnopqrstuvwxyz";
	
	private static Random random = new Random();
	
	public static Character randomChar() {
		final int value = random.nextInt(letters.length() - 1);
		
		return letters.charAt(value);
	}
	
	public static String randomText(int size) {
		final StringBuilder text = new StringBuilder();
		for (int i = 0; i < size; i++) {
			text.append(randomChar());
		}
		
		return text.toString();
	}
}
