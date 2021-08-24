package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
	private String name;
	private int age;
	private List<Student> students = new ArrayList<>();
	
	public University(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public Student getStudentWithAverageGrade(double averageGrade) {
		//TODO:
		for (Student check : students) {
			if (check.getAverageGrade() == averageGrade) {
				return check;
			}
		}
		return null;
	}
	
	public Student getStudentWithMaxAverageGrade() {
		//TODO:
		Student founded = null;
		double grade = Double.MIN_VALUE;
		for (Student check : students) {
			if (check.getAverageGrade() > grade) {
				grade = check.getAverageGrade();
				founded = check;
			}
		}
		return founded;
	}
	
	public Student getStudentWithMinAverageGrade() {
		//TODO:
		Student founded = null;
		double grade = Double.MAX_VALUE;
		for (Student check : students) {
			if (check.getAverageGrade() < grade) {
				grade = check.getAverageGrade();
				founded = check;
			}
		}
		return founded;
	}
	
	public void expel(Student student) {
		//TODO:
		students.remove(student);
	}
}