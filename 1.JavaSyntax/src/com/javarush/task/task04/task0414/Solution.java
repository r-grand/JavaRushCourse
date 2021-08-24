package com.javarush.task.task04.task0414;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Количество дней в году
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader year = new BufferedReader(new InputStreamReader(System.in));
		String sYear = year.readLine();
		int iYear = Integer.parseInt(sYear);
		int x = iYear / 400 * 400;
		int y = iYear / 100 * 100;
		int z = iYear / 4 * 4;

		int v = 366;
		int o = 365;

		if (x == iYear || (y != iYear && z == iYear))
			System.out.println("количество дней в году: " + v);
		else System.out.println("количество дней в году: " + o);
	}
}