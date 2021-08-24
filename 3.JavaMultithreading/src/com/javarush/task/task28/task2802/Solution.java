package com.javarush.task.task28.task2802;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/

public class Solution {
	
	public static void main(String[] args) {
		class EmulatorThreadFactoryTask implements Runnable {
			@Override
			public void run() {
				emulateThreadFactory();
			}
		}
		
		ThreadGroup group = new ThreadGroup("firstGroup");
		Thread thread = new Thread(group, new EmulatorThreadFactoryTask());
		
		ThreadGroup group2 = new ThreadGroup("secondGroup");
		Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());
		
		thread.start();
		thread2.start();
	}
	
	private static void emulateThreadFactory() {
		AmigoThreadFactory factory = new AmigoThreadFactory();
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		};
		factory.newThread(r).start();
		factory.newThread(r).start();
		factory.newThread(r).start();
	}
	
	public static class AmigoThreadFactory implements ThreadFactory {
		private static final AtomicInteger A = new AtomicInteger(1);
		private final ThreadGroup group;
        private final AtomicInteger B = new AtomicInteger(1);
        private final int poolNumber;
		
		public AmigoThreadFactory() {
		    group = Thread.currentThread().getThreadGroup();
		    poolNumber = A.getAndIncrement();
		}
		
		@Override
		public Thread newThread(Runnable r) {
			Thread thread = new Thread(group, r);
			
			if (thread.isDaemon()) {
			    thread.setDaemon(false);
            }
			
			if (thread.getPriority() != Thread.NORM_PRIORITY) {
			    thread.setPriority(Thread.NORM_PRIORITY);
            }
			
			String GN = thread.getThreadGroup().getName();
			thread.setName(String.format("%s-pool-%d-thread-%d", GN, poolNumber, B.getAndIncrement()));
			
			return thread;
		}
	}
}
