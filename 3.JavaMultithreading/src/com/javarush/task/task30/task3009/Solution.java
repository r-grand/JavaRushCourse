package com.javarush.task.task30.task3009;

import java.math.BigInteger;
import java.util.LinkedHashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
	public static void main(String[] args) {
		System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
		System.out.println(getRadix("123"));        //expected output: [6]
		System.out.println(getRadix("5321"));       //expected output: []
		System.out.println(getRadix("1A"));         //expected output: []
	}
	
	private static Set<Integer> getRadix(String number) {
		Set<Integer> systems = new LinkedHashSet<>();
		for (int i = 2; i < 37; i++) {
			try {
				StringBuilder test = new StringBuilder(new BigInteger(number).toString(i));
				String s = test.toString();
				StringBuilder reverse = new StringBuilder(test.reverse());
				if (s.equals(reverse.toString())) {
					systems.add(i);
				}
			} catch (Exception ignored) {
			}
		}
		return systems;
	}
}