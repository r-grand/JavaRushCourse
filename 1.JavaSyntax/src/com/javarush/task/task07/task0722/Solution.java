package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list = new ArrayList<>();
		while (true) {
			String word = reader.readLine();
			if (word.equals("end"))
				break;
			list.add(word);
		}
		for (String string :
				list) {
			System.out.println(string);
		}
	}
}