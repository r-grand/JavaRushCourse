package com.javarush.task.task37.task3707;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		//Считываем число счетов
		int N = console.nextInt();
		//Считываем содержимое счетов
		List<Integer> accounts = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			accounts.add(console.nextInt());
		}
		//Величина комиссии
		double sum = 0;
		//Исходный массив счетов на каждой итерации схлопывания
		List<Integer> input = accounts;
		
		//В цикле схлопываем попарно счета пока не останется ровно один счет
		while (input.size() > 1) {
			//Получившийся после схлопывания массив счетов после каждой итерации
			List<Integer> output = new ArrayList<>(input.size() / 2 + 1);
			
			for (int i = 0; i < input.size(); i = i + 2) {
				//Складываем попарно по порядку все счета и перекладываем в выходящий массив счетов
				if (i < input.size() - 1) {
					//считаем комиссию на каждом шаге схлопывания счетов
					sum = sum + (input.get(i) + input.get(i + 1)) * 0.05;
					//добавляем получившиеся счета в выходящий массив счетов
					output.add(input.get(i) + input.get(i + 1));
					//если остался элемент без пары просто переносим его в выходящий массив
				} else {
					output.add(input.get(i));
				}
			}
			//делаем выходящий массив входящим для следующей итерации схлопывания счетов
			input = output;
		}
		//выводим сумму минимальной комиссии устанавливаем формат с двумя разрядами после запятой, запятую меняем на точку
		//по условию задачи из примера вывода
		System.out.println(String.format("%.2f", sum).replace(",", "."));
	}
}
