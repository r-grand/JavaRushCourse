package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<>();

    public Cat() {
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();
        Cat cat6 = new Cat();
        Cat cat7 = new Cat();
        Cat cat8 = new Cat();
        Cat cat9 = new Cat();
        Cat cat10 = new Cat();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        cats.add(cat5);
        cats.add(cat6);
        cats.add(cat7);
        cats.add(cat8);
        cats.add(cat9);
        cats.add(cat10);
        printCats();
    }

    public static void printCats() {
        System.out.println(cats.get(0));
        System.out.println(cats.get(1));
        System.out.println(cats.get(2));
        System.out.println(cats.get(3));
        System.out.println(cats.get(4));
        System.out.println(cats.get(5));
        System.out.println(cats.get(6));
        System.out.println(cats.get(7));
        System.out.println(cats.get(8));
        System.out.println(cats.get(9));
    }
/*
    @Override
    public String toString() {
        return "Cat";
    }
*/
}