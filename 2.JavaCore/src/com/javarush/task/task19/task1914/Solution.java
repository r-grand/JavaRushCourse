package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
	public static TestString testString = new TestString();
	
	public static void main(String[] args) {
		PrintStream savedOut = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		testString.printSomething();
		System.setOut(savedOut);
		String[] arr = baos.toString().split(" ");
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[2]);
		int math = 0;
		switch (arr[1]) {
			case ("+"):
				math = a + b;
				break;
			case ("-"):
				math = a - b;
				break;
			case ("*"):
				math = a * b;
				break;
		}
		String result = arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + math;
		System.out.println(result);
	}
	
	public static class TestString {
		public void printSomething() {
			System.out.println("3 + 6 = ");
		}
	}
}

