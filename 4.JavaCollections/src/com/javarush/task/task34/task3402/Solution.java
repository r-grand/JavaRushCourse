package com.javarush.task.task34.task3402;

/* 
Факториал с помощью рекурсии
*/

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		System.out.println(solution.factorial(9));     //362880
		System.out.println(solution.factorial(0));     //1
		System.out.println(solution.factorial(1));     //1
		System.out.println(solution.factorial(19));     //1
	}
	
//	public int factorial(int n) {
//		if (n == 0 || n == 1) {
//			return 1;
//		}
//
//		int result = 1;
//		for (int i = 2; i < n + 1; i++) {
//			result *= i;
//		}
//
//		return result;
//	}
	
	public int factorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
}
