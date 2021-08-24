package com.javarush.task.task04.task0424;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Три числа
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(bufferedReader.readLine());
		int y = Integer.parseInt(bufferedReader.readLine());
		int z = Integer.parseInt(bufferedReader.readLine());
		int a = 1, b = 2, c = 3;
		if (x != y && y == z)
			System.out.println(a);
		else if (y != x && x == z)
			System.out.println(b);
		else if (z != x && x == y)
			System.out.println(c);
	}
}
