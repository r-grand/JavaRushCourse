package com.javarush.task.task20.task2020;

import java.io.*;

/* 
Сериализация человека
*/

public class Solution {
	protected int g;
	
	public Solution() {
//		System.out.println("Здесь сработал конструктор класса родителя, перед инициализацией поля g, поэтому оно равно = " + g);
//		this.g = 5;
//		System.out.println("Здесь сработал конструктор класса родителя, после инициализации поля g, теперь оно равно = " + g);
	}
	
	public static class Person extends Solution implements Serializable {
		final String firstName;
		String lastName;
		String country;
//		private static final long serialVersionUID = -2450051098061434754L;
		
		Person(String firstName, String lastName, String country) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.country = country;
		}
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Person originalPersonRoman = new Person("Roman", "Grand", "Russia");
		Person originalPersonMaria = new Person("Maria", "Grand", "Russia");
		Person originalPersonMilena = new Person("Milena", "Grand", "Russia");

		System.out.println("До сериализации:");
		System.out.println(originalPersonRoman.firstName + " + " + originalPersonMaria.firstName + " = " + originalPersonMilena.firstName);

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\idea\\save.dat"));
		oos.writeObject(originalPersonRoman);
		oos.writeObject(originalPersonMaria);
		oos.writeObject(originalPersonMilena);
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\idea\\save.dat"));
		Person loadPerson1 = (Person) ois.readObject();
		Person loadPerson2 = (Person) ois.readObject();
		Person loadPerson3 = (Person) ois.readObject();
		ois.close();
		
		System.out.println("После сериализации:");
		System.out.println(loadPerson1.firstName + " + " + loadPerson2.firstName + " = " + loadPerson3.firstName);
//		System.out.println(loadPerson1.g);
	}
}
