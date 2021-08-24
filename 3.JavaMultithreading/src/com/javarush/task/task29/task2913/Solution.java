package com.javarush.task.task29.task2913;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
	private static int numberA;
	private static int numberB;
	
	public static String getAllNumbersBetween(int a, int b) {
		StringBuilder sb;
		if (a < b) {
			System.out.print(a);
			for (int i = a + 1; i <= b; i++) {
				System.out.print(" " + i);
			}
			return "";
		} else if (a > b) {
			System.out.print(a);
			for (int i = a - 1; i >= b; i--) {
				System.out.print(" " + i);
			}
			return "";
		} else {
			return String.valueOf(a);
		}
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		numberA = random.nextInt(1000);
		numberB = random.nextInt(1000);
		System.out.println(getAllNumbersBetween(numberA, numberB));
		System.out.println(getAllNumbersBetween(numberB, numberA));
	}
}