package com.javarush.task.task19.task1911;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

/* 
Ридер обертка
*/

public class Solution {
	public static TestString testString = new TestString();
	
	public static void main(String[] args) {
		PrintStream savedOut = System.out;
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		PrintStream substitute = new PrintStream(baos);
		System.setOut(substitute);
		testString.printSomething();
		String test = baos.toString().toUpperCase(Locale.ROOT);
		System.setOut(savedOut);
        System.out.println(test);
	}
	
	public static class TestString {
		public void printSomething() {
			System.out.println("it's a text for testing");
		}
	}
}
