package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
	public static List<String> words = new ArrayList<>();
	
	static {
		words.add("файл");
		words.add("вид");
		words.add("В");
	}
	
	public static void main(String[] args) throws IOException {
		String fileName;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			fileName = reader.readLine();
		}
		int count = 0;
		try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
			while (fileReader.ready()) {
				String line = fileReader.readLine();
				String[] arr = line.split(" ");
				for (int i = 0; i < arr.length; i++) {
					if (words.contains(arr[i])) {
						count++;
					}
				}
				if (count == 2) {
					System.out.println(line);
				}
				count = 0;
			}
		}
	}
}
