package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("роза");
		strings.add("лоза");
		strings.add("лира");
		strings = fix(strings);

		for (String string : strings) {
			System.out.println(string);
		}
	}

	public static ArrayList<String> fix(ArrayList<String> strings) {
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).indexOf('р') != -1 && strings.get(i).indexOf('л') == -1) {
				strings.remove(i);
				i--;
			}
		}
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).indexOf('л') != -1 && strings.get(i).indexOf('р') == -1) {
				strings.add(i, strings.get(i));
				i++;
			}
		}
		return strings;
	}
}