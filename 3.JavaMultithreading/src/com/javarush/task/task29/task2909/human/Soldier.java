package com.javarush.task.task29.task2909.human;

public class Soldier extends Human {
	protected int course;
	
	public Soldier(String name, int age) {
		super(name, age);
	}
	
	@Override
	public int getAge() {
		return super.getAge();
	}
	
	@Override
	public void setAge(int age) {
		super.setAge(age);
	}
	
	@Override
	public String getName() {
		return super.getName();
	}
	
	@Override
	public void setName(String name) {
		super.setName(name);
	}
	
	@Override
	public void live() {
		fight();
	}
	
	public void fight() {
	}
	
	public int getCourse() {
		return course;
	}
}
