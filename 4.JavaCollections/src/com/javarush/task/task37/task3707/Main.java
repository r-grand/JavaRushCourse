package com.javarush.task.task37.task3707;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		//Считываем с консоли количество банковских счетов
		int n = console.nextInt();
		//В цикле считываем с консоли содержимое каждого счёта и записываем
		// в список с размером равным 'n'
		List<Integer> accounts = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			accounts.add(console.nextInt());
		}
		
		//Создаём переменную с плавающей точкой для вычисления общей величины комиссии
		double sum = 0;
		//Дублируем исходный список счетов на каждой итерации соединения
		List<Integer> input = accounts;
		
		//В цикле соединяем попарно счета пока не останется ровно один счёт
		while (input.size() > 1) {
			//Создаём список для хранения счетов, получившихся после
			// попарного соединения после каждой итерации
			List<Integer> output = new ArrayList<>(input.size() / 2 + 1);
			
			//В цикле попарно складываем по порядку все счета и перекладываем
			// в выходящий список счетов
			for (int i = 0; i < input.size(); i += 2) {
				//Проверяем, есть ли у следующего элемента пара
				if (i < input.size() - 1) {
					//Считаем комиссию на каждом шаге соединения счетов
					sum += (input.get(i) + input.get(i + 1)) * 0.05;
					//Добавляем получившиеся счета в выходящий список счетов
					output.add(input.get(i) + input.get(i + 1));
					//Если остался элемент без пары, то просто переносим его
					// в выходящий список счетов
				} else {
					output.add(input.get(i));
				}
			}
			
			//Делаем выходящий список входящим для проведения следующей
			// итерации соединения счетов
			input = output;
		}
		
		//Выводим на экран полученную сумму минимальной комиссии, устанавливаем формат
		// с двумя разрядами после запятой и меняем разделительный знак (',' на '.'),
		// как это сделано в примере вывода из условий задачи
		System.out.println(String.format("%.2f", sum).replace(",", "."));
	}
}