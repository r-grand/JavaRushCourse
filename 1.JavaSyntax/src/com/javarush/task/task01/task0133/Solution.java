package com.javarush.task.task01.task0133;

/* 
Не думать о секундах…
*/


import java.io.IOException;

public class Solution {
	public static void main(String[] args) throws IOException {
		for (int i = 900; i <= 5000; i = i + 1000) {
			System.out.printf("Каждый год, на протяжении 5ти лет, моя зарплата/месяц будет изменяться. Итог - $" + i + " \n");
		}
	}
}