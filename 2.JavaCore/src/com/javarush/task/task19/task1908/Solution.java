package com.javarush.task.task19.task1908;

import java.io.*;

/* 
Выделяем числа
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		String fileName1;
		String fileName2;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			fileName1 = reader.readLine();
			fileName2 = reader.readLine();
		}
		
		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName1));
			 BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))) {
			while (reader.ready()) {
				sb.append((char) reader.read());
			}
			String[] text = sb.toString().split(" ");
			int temp;
			for (String check : text) {
				try {
					temp = Integer.parseInt(check);
				} catch (NumberFormatException e) {
					continue;
				}
				writer.write(temp + " ");
			}
		}
	}
}
