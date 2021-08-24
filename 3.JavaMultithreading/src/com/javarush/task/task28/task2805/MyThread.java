package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
	private final static AtomicInteger priority = new AtomicInteger(1);
	
	{
		this.setPriority(priority.getAndIncrement());
		int groupPriority = this.getThreadGroup().getMaxPriority();
		if (groupPriority < this.getPriority()) {
			this.setPriority(groupPriority);
		}
		if (priority.get() == 11) {
			priority.set(1);
		}
	}
	
	public MyThread() {
	}
	
	public MyThread(Runnable target) {
		super(target);
	}
	
	public MyThread(ThreadGroup group, Runnable target) {
		super(group, target);
	}
	
	public MyThread(String name) {
		super(name);
	}
	
	public MyThread(ThreadGroup group, String name) {
		super(group, name);
	}
	
	public MyThread(Runnable target, String name) {
		super(target, name);
	}
	
	public MyThread(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
	}
	
	public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);
	}
}
