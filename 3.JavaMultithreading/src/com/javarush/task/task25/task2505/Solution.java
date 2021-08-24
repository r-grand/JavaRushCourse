package com.javarush.task.task25.task2505;

/* 
Без дураков
*/

public class Solution {
	
	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new Solution().new MyThread("super secret key");
		myThread.start();
//		myThread.join();
	}
	
	public class MyThread extends Thread {
		private String secretKey;
		
		private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				try {
					Thread.sleep(500);
					String result = String.format("%s, %s, %s", secretKey, t.getName(), e.getMessage());
					System.out.println(result);
//					System.out.printf("%s, %s, %s%n", secretKey, t.getName(), e.getMessage());
				} catch (InterruptedException interruptedException) {
					interruptedException.printStackTrace();
				}
			}
		}
		
		public MyThread(String secretKey) {
			this.secretKey = secretKey;
			setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
//			setDaemon(true);
		}
		
		@Override
		public void run() {
			throw new NullPointerException("it's an example");
		}
	}
	
}

