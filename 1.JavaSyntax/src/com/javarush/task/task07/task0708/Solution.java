package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
	private static ArrayList<String> strings;

	public static void main(String[] args) throws Exception {
		strings = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			strings.add(reader.readLine());
		}

		String s1 = strings.get(0);
		String s2 = strings.get(1);
		String s3 = strings.get(2);
		String s4 = strings.get(3);
		String s5 = strings.get(4);
		int i1 = strings.get(0).length();
		int i2 = strings.get(1).length();
		int i3 = strings.get(2).length();
		int i4 = strings.get(3).length();
		int i5 = strings.get(4).length();

		int max = 0;


		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).length() > max) {
				max = strings.get(i).length();
			}
		}

		if (i1 == max)
			System.out.println(s1);
		if (i2 == max)
			System.out.println(s2);
		if (i3 == max)
			System.out.println(s3);
		if (i4 == max)
			System.out.println(s4);
		if (i5 == max)
			System.out.println(s5);
	}
}
