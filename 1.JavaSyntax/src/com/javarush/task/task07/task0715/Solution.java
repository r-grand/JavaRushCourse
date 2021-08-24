package com.javarush.task.task07.task0715;

import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
	public static void main(String[] args) {
		ArrayList<String> bukvar = new ArrayList<>();
		bukvar.add("мама");
		bukvar.add("мыла");
		bukvar.add("раму");

		for (int i = 0; i < bukvar.size(); i += 2) {
            bukvar.add(i + 1, "именно");
            System.out.println(bukvar.get(i));
            System.out.println(bukvar.get(i + 1));
		}
	}
}
