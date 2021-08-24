package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
	private List<Horse> horses;
	static Hippodrome game;
	
	public Hippodrome(List<Horse> horses) {
		this.horses = horses;
	}
	
	public List<Horse> getHorses() {
		return horses;
	}
	
	public void run() throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			move();
			print();
			Thread.sleep(200);
		}
	}
	
	public void move() {
		for (Horse horse : horses) {
		    horse.move();
		}
	}
	
	public void print() {
		for (Horse horse : horses) {
			horse.print();
		}
		for (int i = 0; i < 3; i++) {
			System.out.println();
		}
	}
	
	public Horse getWinner() {
		Horse winner = null;
		double dist = 0;
		for (Horse check : horses) {
		    if (check.getDistance() > dist) {
		    	dist = check.getDistance();
		    	winner = check;
			}
		}
		return winner;
	}
	
	public void printWinner() {
		System.out.printf("Winner is %s!", getWinner().getName());
	}
	
	public static void main(String[] args) throws InterruptedException {
		game = new Hippodrome(new ArrayList<>());
		game.horses.add(new Horse("Albert", 3, 0));
		game.horses.add(new Horse("Arturo", 3, 0));
		game.horses.add(new Horse("Henrich", 3, 0));
		game.horses.add(new Horse("Lucky", 3, 0));
		game.horses.add(new Horse("Monarch", 3, 0));
		game.horses.add(new Horse("Death", 3, 0));
		game.horses.add(new Horse("Baron", 3, 0));
		game.horses.add(new Horse("Flawless", 3, 0));
		game.horses.add(new Horse("Victory", 3, 0));
		game.horses.add(new Horse("Minsk", 3, 0));
		game.run();
		game.printWinner();
	}
}
