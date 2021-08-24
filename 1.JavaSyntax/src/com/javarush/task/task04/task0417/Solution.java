package com.javarush.task.task04.task0417;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Существует ли пара?
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader kat = new BufferedReader(new InputStreamReader(System.in));
		String sA = kat.readLine();
		String sB = kat.readLine();
		String sC = kat.readLine();
		int a = Integer.parseInt(sA);
		int b = Integer.parseInt(sB);
		int c = Integer.parseInt(sC);

		if (a == b && b == c)
			System.out.println(a + " " + b + " " + c);
		else {
			if (a == b)
				System.out.println(a + " " + b);
			if (a == c)
				System.out.println(a + " " + c);
			if (b == c)
				System.out.println(b + " " + c);
		}
	}
}