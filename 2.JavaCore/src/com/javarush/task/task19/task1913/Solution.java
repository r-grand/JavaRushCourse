package com.javarush.task.task19.task1913;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Выводим только цифры
*/

public class Solution {
	public static TestString testString = new TestString();
	
	public static void main(String[] args) {
	    PrintStream savedOut = System.out;
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(byteArrayOutputStream));
	    testString.printSomething();
	    System.setOut(savedOut);
	    String text = byteArrayOutputStream.toString().replaceAll("[^\\p{Digit}]", "");
        System.out.println(text);
	}
	
	public static class TestString {
		public void printSomething() {
			System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
		}
	}
}
