package com.javarush.task.task05.task0527;

/* 
Том и Джерри
*/

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        System.out.println(jerryMouse);
        Cat tomCat = new Cat("Tom", 40, 22);
        System.out.println(tomCat);
        Dog pitbullDog = new Dog("Pitbull", 75, 25);
        System.out.println(pitbullDog);
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }

        public String toString() {
            return "Mouse " + this.name + ", height - " + this.height + ", tail - " + this.tail;
        }
    }

    public static class Dog {
        String name;
        int height;
        int tail;

        public Dog(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }

        public String toString() {
            return "Dog " + this.name + ", height - " + this.height + ", tail - " + this.tail;
        }
    }

    public static class Cat {
        String name;
        int height;
        int tail;

        public Cat(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }

        public String toString() {
            return "Cat " + this.name + ", height - " + this.height + ", tail - " + this.tail;
        }
    }
}
