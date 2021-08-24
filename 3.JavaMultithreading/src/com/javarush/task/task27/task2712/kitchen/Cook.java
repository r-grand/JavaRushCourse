package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
	private final String name;
	private boolean busy;
	private LinkedBlockingQueue<Order> queue;
	
	public Cook(String name) {
		this.name = name;
	}
	
	public boolean isBusy() {
		return busy;
	}
	
	public void setQueue(LinkedBlockingQueue<Order> queue) {
		this.queue = queue;
	}
	
	public void startCookingOrder(Order order) throws InterruptedException {
		busy = true;
		ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", order, order.getTotalCookingTime()));
		setChanged();
		notifyObservers(order);
		StatisticManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes()));
		Thread.sleep(order.getTotalCookingTime() * 10L);
		busy = false;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(10);
				if (!queue.isEmpty()) {
					if (!isBusy()) {
						startCookingOrder(queue.take());
					}
				}
			}
		} catch (InterruptedException ignored) {
		}
	}
}
