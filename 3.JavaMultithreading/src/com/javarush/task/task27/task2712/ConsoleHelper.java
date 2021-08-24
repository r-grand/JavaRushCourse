package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ConsoleHelper {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void writeMessage(String message) {
		System.out.println(message);
	}
	
	public static String readString() throws IOException {
		return reader.readLine();
	}
	
	public static List<Dish> getAllDishesForOrder() throws IOException {
		List<Dish> order = new ArrayList<>();
		System.out.println(Dish.allDishesToString());
		String answer;
		System.out.println("Введите название блюда для добавления к заказу, или \"exit\" для завершения заказа:");
		while (!"exit".equalsIgnoreCase(answer = readString())) {
			try {
				order.add(Dish.valueOf(answer.toUpperCase(Locale.ROOT)));
				ConsoleHelper.writeMessage("Блюдо " + answer.toUpperCase(Locale.ROOT) + " успешно добавлено в ваш заказ");
			} catch (IllegalArgumentException e){
				System.out.println("Блюдо под названием " + answer.toUpperCase(Locale.ROOT) + " отсутствует в меню.");
			}
		}
		return order;
	}
}
