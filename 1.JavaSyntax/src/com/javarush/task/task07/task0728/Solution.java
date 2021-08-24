package com.javarush.task.task07.task0728;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
В убывающем порядке
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] strings = new String[5];
		int[] ints = new int[5];

		for (int j = 0; j < 5; j++) {
			String s = reader.readLine();
			strings[j] = s;
			int i = 0;
			while (i >= Integer.parseInt(s) || i <= Integer.parseInt(s)) {
				ints[j] = Integer.parseInt(s);
				break;
			}
		}

		System.out.println(Arrays.toString(strings));
		System.out.println(Arrays.toString(ints));
	}
}
