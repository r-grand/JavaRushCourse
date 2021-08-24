package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
	public static void main(String[] args) {
		readData();
	}

	public static void readData() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> integers = new ArrayList<>();

		while (true)
			try {
				integers.add(Integer.parseInt(reader.readLine()));
			} catch (NumberFormatException | IOException e) {
				for (int ints :
						integers) {
					System.out.println(ints);
				}
				break;
			}
	}
}
