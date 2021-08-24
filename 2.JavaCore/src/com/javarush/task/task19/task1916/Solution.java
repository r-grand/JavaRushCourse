package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Отслеживаем изменения
*/

public class Solution {
	public static List<LineItem> lines = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		String file1;
		String file2;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			file1 = reader.readLine();
			file2 = reader.readLine();
		}
		Deque<String> list1 = new ArrayDeque<>();
		Deque<String> list2 = new ArrayDeque<>();
		try (BufferedReader fileReader1 = new BufferedReader(new FileReader(file1));
			 BufferedReader fileReader2 = new BufferedReader(new FileReader(file2))) {
			while (fileReader1.ready()) {
				list1.add(fileReader1.readLine());
			}
			while (fileReader2.ready()) {
				list2.add(fileReader2.readLine());
			}
		}
		while (list1.size() > 0 && list2.size() > 0) {
			String line1 = list1.pollFirst();
			String line2 = list2.pollFirst();
			if (line1.equals(line2)) {
				lines.add(new LineItem(Type.SAME, line1));
			} else if (list1.peekFirst().equals(line2)) {
				lines.add(new LineItem(Type.REMOVED, line1));
				list2.addFirst(line2);
			} else {
				lines.add(new LineItem(Type.ADDED, line2));
				list1.addFirst(line1);
			}
		}
		while (!list1.isEmpty()) {
			String temp = list1.pollFirst();
			lines.add(new LineItem(Type.REMOVED, temp));
		}
		while (!list2.isEmpty()) {
			String temp = list2.pollFirst();
			lines.add(new LineItem(Type.ADDED, temp));
		}
	}
	
	public enum Type {
		ADDED,        //добавлена новая строка
		REMOVED,      //удалена строка
		SAME          //без изменений
	}
	
	public static class LineItem {
		public Type type;
		public String line;
		
		public LineItem(Type type, String line) {
			this.type = type;
			this.line = line;
		}
	}
}
