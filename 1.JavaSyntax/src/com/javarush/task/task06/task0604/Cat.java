package com.javarush.task.task06.task0604;

/* 
Ставим котов на счётчик
*/

class Cat {                  //класс
	String name;            //обычная переменная
	static int catCount;    //статическая переменная

	Cat(String name) {
		this.name = name;
		catCount++;   //увеличиваем значение статический переменной на 1
	}

	public static void main(String[] args) {
		System.out.println(catCount);
		Cat cat1 = new Cat("Max");

		System.out.println(catCount);
		Cat cat2 = new Cat("Mike");

		System.out.println(cat1.name);
		System.out.println(cat2.name);
		System.out.println(catCount);
	}
}