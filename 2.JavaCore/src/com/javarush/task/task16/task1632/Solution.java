package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
	public static List<Thread> threads = new ArrayList<>(5);
	
	static {
		TestThread1 tt1 = new TestThread1();
		TestThread2 tt2 = new TestThread2();
		TestThread3 tt3 = new TestThread3();
		TestThread4 tt4 = new TestThread4();
		TestThread5 tt5 = new TestThread5();
		threads.add(tt1);
		threads.add(tt2);
		threads.add(tt3);
		threads.add(tt4);
		threads.add(tt5);
	}
	
	public static void main(String[] args) {
		threads.get(4).start();
	}
	
	public static class TestThread1 extends Thread {
		@Override
		public void run() {
			while (true) {
			}
		}
	}
	
	public static class TestThread2 extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		}
	}
	
	public static class TestThread3 extends Thread {
		@Override
		public void run() {
			while (true) {
				System.out.println("Ура");
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static class TestThread4 extends Thread implements Message {
		@Override
		public void run() {
			while (!isInterrupted()) {}
		}
		
		@Override
		public void showWarning() {
			interrupt();
		}
	}
	
	public static class TestThread5 extends Thread {
		private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		private String check;
		private List<Integer> ints = new ArrayList<>();
		private int sum;
		
		@Override
		public void run() {
			while (true) {
				try {
					if ((check = br.readLine()).equals("N")) {
						break;
					} else {
						ints.add(Integer.parseInt(check));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			for (int i : ints) {
			    sum += i;
			}
			System.out.println(sum);
		}
	}
}