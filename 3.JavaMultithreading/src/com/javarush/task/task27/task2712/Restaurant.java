package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
	private static final int ORDER_CREATING_INTERVAL = 100;
	private static final LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>(200);
	
	public static void main(String[] args) throws IOException, InterruptedException {
		List<Tablet> tablets = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			Tablet tablet = new Tablet(i);
			tablet.setQueue(ORDER_QUEUE);
			tablets.add(tablet);
		}
		
		Cook amigo = new Cook("Amigo");
		amigo.setQueue(ORDER_QUEUE);
		Cook r2d2 = new Cook("R2D2");
		r2d2.setQueue(ORDER_QUEUE);
		
		Waiter waiter = new Waiter();
		amigo.addObserver(waiter);
		r2d2.addObserver(waiter);
		
		Thread cook1 = new Thread(amigo);
		cook1.start();
		Thread cook2 = new Thread(r2d2);
		cook2.start();
		
		Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
		thread.start();
		
		try {
			Thread.sleep(5000);
			thread.interrupt();
			cook1.interrupt();
			cook2.interrupt();
			thread.join();
			Thread.sleep(1500);
		} catch (InterruptedException ignored) {
		}
		
		DirectorTablet directorTablet = new DirectorTablet();
		directorTablet.printAdvertisementProfit();
		directorTablet.printCookWorkloading();
		directorTablet.printActiveVideoSet();
		directorTablet.printArchivedVideoSet();
	}
}
