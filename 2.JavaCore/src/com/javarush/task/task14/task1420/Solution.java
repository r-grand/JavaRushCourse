package com.javarush.task.task14.task1420;

/*
НОД
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		int x = positiveInteger();
		int y = positiveInteger();
		ArrayList<Integer> divisors = new ArrayList<>();
		
		for (int i = x; i > 0; i--) {
			if (x % i == 0) {
				divisors.add(i);
			}
		}
		
		for (int result : divisors) {
			if (y % result == 0) {
				System.out.println(result);
				break;
			}
		}
	}
	
	public static int positiveInteger() {
		Scanner input = new Scanner(System.in);
		
		int number = input.nextInt();
			if (number <= 0) {
				throw new IllegalArgumentException();
			} else {
				return number;
			}
	}
}
