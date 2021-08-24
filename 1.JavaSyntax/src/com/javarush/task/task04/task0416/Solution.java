package com.javarush.task.task04.task0416;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переходим дорогу вслепую
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader minute = new BufferedReader(new InputStreamReader(System.in));
		double t = Double.parseDouble(minute.readLine());
		double d = t % 5;

		if (0 <= d && d < 3)
            System.out.println("зелёный");
		else if (3 <= d && d < 4)
            System.out.println("жёлтый");
		else
            System.out.println("красный");
	}
}