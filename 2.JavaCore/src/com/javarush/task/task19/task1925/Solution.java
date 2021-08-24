package com.javarush.task.task19.task1925;

import java.io.*;

/* 
Длинные слова
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
			while (fileReader.ready()) {
				sb.append(fileReader.readLine()).append(" ");
			}
		}
		String[] words = sb.toString().trim().split(" ");
		StringBuilder string = new StringBuilder();
		try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]))) {
			for (String word : words) {
				if (word.length() > 6) string.append(word + ",");
			}
			fileWriter.write(string.substring(0, string.length() - 1));
		}
	}
}