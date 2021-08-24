package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		File file = new File(reader.readLine());
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(fileWriter);
		String text = "start";
		
		while (!text.equals("exit")) {
			text = reader.readLine();
			writer.write(text + "\n");
		}
		
		writer.close();
	}
}
