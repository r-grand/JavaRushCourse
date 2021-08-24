package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
	private Thread thread;
	
	public LoggingStateThread(Thread thread) {
		this.thread = thread;
		this.thread.setDaemon(true);
	}
	
	@Override
	public void run() {
		String status = thread.getState().name();
		System.out.println(status);
		while (true) {
			if (!status.equals(thread.getState().name())) {
				status = thread.getState().name();
				System.out.println(thread.getState());
			}
			if (thread.getState().equals(State.TERMINATED)) return;
		}
//		System.out.println(thread.getState());
	}
}
