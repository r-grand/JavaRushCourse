package com.javarush.task.task18.task1816;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader(args[0]);
		Set<Character> set = new HashSet<>();
		char t;
		int count = 0;
		while (fr.ready()) {
			t = (char) fr.read();
			if ((t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z')) {
				count++;
			}
		}
		fr.close();
		System.out.println(count);
	}
}

