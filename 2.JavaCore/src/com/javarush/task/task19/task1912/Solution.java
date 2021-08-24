package com.javarush.task.task19.task1912;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка 2
*/

public class Solution {
	public static TestString testString = new TestString();
	
	public static void main(String[] args) {
		PrintStream savedOut = System.out;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteArrayOutputStream));
		testString.printSomething();
		System.setOut(savedOut);
		char[] arr = byteArrayOutputStream.toString().toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 't' && arr[i + 1] == 'e') {
				arr[i] = '?';
				arr[i + 1] = '?';
			}
		}
		for (char c : arr) {
			System.out.print(c);
		}
	}
	
	public static class TestString {
		public void printSomething() {
			System.out.println("it's a text for testing");
		}
	}
}
