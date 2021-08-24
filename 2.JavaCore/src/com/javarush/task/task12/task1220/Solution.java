package com.javarush.task.task12.task1220;

/* 
Класс Human и интерфейсы CanRun, CanSwim
*/

public class Solution {
	
	public void ShowNums(int i) {
		// метод, который печатает

// блок try проверяет, достигли ли мы нуля
		try {
			int x = 101 - i;
			int m = x / i;                // здесь выбрасывается исключение при i = 0
			System.out.println(x);
			i--;
			ShowNums(i);                // а вот и рекурсивный вызов
		} catch (ArithmeticException e) {
			// деление на нуль выбрасывает ArithmeticException
			return;                    // Останавливается при попытке деления на нуль
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Solution rec = new Solution();
		rec.ShowNums(100);
	}
}
