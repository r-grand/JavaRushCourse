package com.javarush.task.task15.task1519;

/*
Разные методы для разных типов
*/

import java.io.*;

public class Solution {
	
	static int counter = 0;
	static int garbage = 0;
	String name;
	
	public Solution(int counter) throws IOException {
		this.counter = counter;
		System.out.println(counter);
	}
	
	public static void main(String[] args) throws Throwable {
		for (int i = 1 ; i <= 95000; i++) {
			
			Solution solution = new Solution(i);
			solution.name = "№" + i;
			solution = null;//вот здесь первый объект становится доступен сборщику мусора
		}
	}
	
	@Override
	protected void finalize() {
		garbage++;
		System.out.println("Объект " + this.name + " уничтожен! " + garbage);
	}
}