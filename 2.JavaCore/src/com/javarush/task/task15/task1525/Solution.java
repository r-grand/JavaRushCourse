package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
	public static List<String> lines = new ArrayList<>();
	
	static {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Statics.FILE_NAME));
			String s;
			while ((s = reader.readLine()) != null) {
				lines.add(s);
			}
		} catch (FileNotFoundException e) {
			System.out.println("В переменной Statics.FILE_NAME не найден путь к файлу для чтения");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(lines);
	}
}
