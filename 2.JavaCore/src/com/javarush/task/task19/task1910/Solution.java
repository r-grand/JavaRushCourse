package com.javarush.task.task19.task1910;

import java.io.*;

/* 
Пунктуация
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName1 = reader.readLine();
		String fileName2 = reader.readLine();
		reader.close();
		reader = new BufferedReader(new FileReader(fileName1));
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
		String temp;
		String result;
		
		while (reader.ready()) {
			temp = reader.readLine();
			result = temp.replaceAll("\\p{Punct}|\n", "");
			writer.write(result);
		}
		
		writer.close();
		reader.close();
	}
}
