package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
	public static TestString testString = new TestString();
	
	public static void main(String[] args) {
		PrintStream savedOut = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		testString.printSomething();
		System.setOut(savedOut);
		String[] text = baos.toString().split("\n");
		int count = 0;
		for (String line : text) {
			System.out.println(line);
			count++;
			if (count == 2) {
				System.out.println("JavaRush - курсы Java онлайн");
				count = 0;
			}
		}
	}
	
	public static class TestString {
		public void printSomething() {
			System.out.println("first");
			System.out.println("second");
			System.out.println("third");
			System.out.println("fourth");
			System.out.println("fifth");
		}
	}
}
