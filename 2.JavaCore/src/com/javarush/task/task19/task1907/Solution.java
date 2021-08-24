package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		String fileName;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			fileName = reader.readLine();
		}
		
		StringBuilder sb = new StringBuilder();
		try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
			while (fileReader.ready()) {
				sb.append((char) fileReader.read());
			}
		}
		
		int world = 0;
		String text = sb.toString();
		String[] arr = text.split("[^a-zA-Z]+");
		for (String check : arr) {
		    if ("world".equals(check)) {
		    	world++;
			}
		}
		System.out.println(world);
	}
}
