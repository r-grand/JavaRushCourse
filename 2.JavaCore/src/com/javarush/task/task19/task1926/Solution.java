package com.javarush.task.task19.task1926;

import java.io.*;

/* 
Перевертыши
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			 BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {
			while (fileReader.ready()) {
				System.out.println(new StringBuilder(fileReader.readLine()).reverse());
			}
		}
	}
}
