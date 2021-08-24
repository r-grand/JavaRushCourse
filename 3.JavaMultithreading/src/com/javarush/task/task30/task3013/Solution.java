package com.javarush.task.task30.task3013;

/* 
Битовые операции
*/

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int number = 255;
		System.out.println(Integer.toString(number, 2));
		
		System.out.println(solution.resetLowerBits(number));
		String result = Integer.toString(solution.resetLowerBits(number), 2);
		System.out.println(result);
	}
	
	public int resetLowerBits(int number) {
		number = number | number >> 1;
		number = number | number >> 2;
		number = number | number >> 4;
		number = number | number >> 8;
		number = number | number >> 16;
		return number & ~(number >> 1);
	}
	
/*	это был мой вариант, но он не подходил под условие задачи))
	private int hah(int number) {
		for (int i = 1073741824; i > 1; ) {
			if (number / i == 1) {
				return i;
			}
			i = i / 2;
		}
		return 1;
	}
*/
}