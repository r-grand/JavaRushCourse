package com.javarush.task.task10.task1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		String strings = "hi";

		while (!strings.isEmpty()) {
			int ints;
			try {
				ints = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e) {
				break;
			}
			strings = reader.readLine();
			if (!strings.isEmpty()) {
				map.put(strings, ints);
			} else { System.out.println(ints); }
		}

		for (Map.Entry<String, Integer> pair :
				map.entrySet()) {
			System.out.println(pair.getValue() + " " + pair.getKey());
		}
	}
}
