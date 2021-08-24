package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

import java.text.DecimalFormat;

public class Solution {
	public static void main(String[] args) throws TooShortStringException {
		System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
	}
	
	public static String getPartOfString(String string) throws TooShortStringException {
		if (string == null) throw new TooShortStringException();
		String[] strings = string.split(" ");
		if (strings.length < 5) throw new TooShortStringException();
		StringBuilder subString = new StringBuilder();
		for (int i = 1; i < 5; i++) {
			subString.append(strings[i] + " ");
		}
		return subString.toString().trim();
	}
	
	public static class TooShortStringException extends RuntimeException {
	}
}