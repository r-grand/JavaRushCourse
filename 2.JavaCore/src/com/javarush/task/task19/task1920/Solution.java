package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Самый богатый
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		Map<String, Double> salaries = new TreeMap<>();
		while (reader.ready()) {
			String[] temp = reader.readLine().split(" ");
			if (salaries.containsKey(temp[0])) {
				salaries.put(temp[0], salaries.get(temp[0]) + Double.parseDouble(temp[1]));
			} else {
				salaries.put(temp[0], Double.parseDouble(temp[1]));
			}
		}
		reader.close();
		double maxCash = 0;
		for (Map.Entry<String, Double> pair : salaries.entrySet()) {
		    if (maxCash < pair.getValue()) {
		    	maxCash = pair.getValue();
			}
		}
		for (Map.Entry<String, Double> pair : salaries.entrySet()) {
			if (maxCash == pair.getValue()) {
				System.out.println(pair.getKey());
			}
		}
	}
}