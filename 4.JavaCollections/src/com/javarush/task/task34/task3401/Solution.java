package com.javarush.task.task34.task3401;

/* 
Числа Фибоначчи с помощью рекурсии
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		System.out.println(solution.fibonacci(9));     //34
		System.out.println(solution.fibonacci(5));     //5
		System.out.println(solution.fibonacci(2));     //1
		System.out.println(solution.fibonacci(1));     //1
		System.out.println(solution.fibonacci(45));     //1
	}
	
//	public int fibonacci(int n) {
//		List<Integer> digits = new ArrayList<>();
//		digits.add(1);
//		digits.add(1);
//		int count = 1;
//
//		while (count < n) {
//			count++;
//			digits.add(digits.get(digits.size() - 1) + digits.get(digits.size() - 2));
//		}
//		if (n > 0) {
//			return digits.get(n - 1);
//		} else {
//			return 0;
//		}
//	}
	
	public int fibonacci(int n) {
		if (n == 1 || n == 2)
			return 1;
		else return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
