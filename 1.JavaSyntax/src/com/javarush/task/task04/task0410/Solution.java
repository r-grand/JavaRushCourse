package com.javarush.task.task04.task0410;

/* 
Попадём-не-попадём
*/

public class Solution {
	public static void main(String[] args) {
		checkInterval(60);
		checkInterval(112);
		checkInterval(10);
	}

	public static void checkInterval(int number) {
		boolean x = 50 <= number;
		boolean y = number <= 100;
		if (x == true) {
			if (y == true)
				System.out.println("Число " + number + " содержится в интервале.");
		}
		if (x == false) {
			if (y == true)
				System.out.println("Число " + number + " не содержится в интервале.");
		}
		if (x == true) {
			if (y == false)
				System.out.println("Число " + number + " не содержится в интервале.");
		}
	}
}