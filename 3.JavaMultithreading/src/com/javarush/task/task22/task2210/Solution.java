package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
	public static void main(String[] args) {
		String[] s = getTokens("level22.lesson13.task01", ".");
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}
	
	public static String[] getTokens(String query, String delimiter) {
		List<String> strings = new ArrayList<>();
		StringTokenizer sT = new StringTokenizer(query, delimiter);
		while (sT.hasMoreTokens()) {
			strings.add(sT.nextToken());
		}
		return strings.toArray(new String[0]);
	}
}
