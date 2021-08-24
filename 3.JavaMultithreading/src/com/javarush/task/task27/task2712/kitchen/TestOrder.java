package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order {
	public TestOrder(Tablet tablet) throws IOException {
		super(tablet);
	}
	
	@Override
	protected void initDishes() {
		dishes = new ArrayList<>();
		int quantity = (int) (Math.random() * 4);
		
		for (int i = 0; i < quantity; i++) {
			int dish = (int) (Math.random() * 5);
			dishes.add(Dish.values()[dish]);
		}
	}
}
