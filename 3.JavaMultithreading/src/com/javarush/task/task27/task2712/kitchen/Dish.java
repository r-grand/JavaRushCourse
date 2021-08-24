package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

public enum Dish {
	FISH(25),
	STEAK(30),
	SOUP(15),
	JUICE(5),
	WATER(3);
	
	private int duration;
	
	Dish(int duration) {
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public static String allDishesToString() {
		StringBuilder builder = new StringBuilder();
		builder.append(Arrays.toString(Dish.values()));
		builder.deleteCharAt(0).deleteCharAt(builder.length() - 1);
		return builder.toString();
	}
}
