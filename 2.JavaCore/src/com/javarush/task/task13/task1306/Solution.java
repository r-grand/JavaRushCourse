package com.javarush.task.task13.task1306;

/* 
Баг в initializeIdAndName
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Hello");
		String text = list.get(0);
		System.out.print(text);
	}
}