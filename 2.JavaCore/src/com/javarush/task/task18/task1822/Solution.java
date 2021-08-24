package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Поиск данных внутри файла
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new FileReader((new BufferedReader(new InputStreamReader(System.in))).readLine()));
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			String[] strings = line.split(" ");
			if (args[0].equals(strings[0])) {
				System.out.println(line);
			}
		}
		scanner.close();
	}
}
