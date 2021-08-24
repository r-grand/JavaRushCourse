package com.javarush.task.task18.task1817;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

/* 
Пробелы
*/

public class Solution {
	public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		int all = 0;
		double space = 0.0;
		int s;
		while ((s = reader.read()) != -1) {
            if (s == ' ') {
                space++;
            }
            all++;
        }
		reader.close();
        System.out.println(Math.round(space / all * 10000) / 100.0d);
	}
}
