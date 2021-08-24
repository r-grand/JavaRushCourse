package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		double sum = 0;
		double count = 0;

		while (true) {
			double x = Double.parseDouble(bufferedReader.readLine());
			if (x != -1) {
				sum += x;
				count++;
			}
			else break;
		}
		double middle = sum / count;
		System.out.println(middle);
	}
}

