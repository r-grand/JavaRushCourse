package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String firstName;
        private String lastName;
        private int age;
        private boolean sex;
        private double height;
        private long money;

        public Human(String firstName, String lastName, int age, boolean sex, double height, long money) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.height = height;
            this.money = money;
        }

        public Human(String firstName, String lastName, int age, boolean sex, double height) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.height = height;
        }

        public Human(String firstName, String lastName, int age, boolean sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
        }

        public Human(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Human(String firstName, String lastName, boolean sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
        }

        public Human(String firstName, String lastName, double height) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.height = height;
        }

        public Human(String firstName, String lastName, boolean sex, double height) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.height = height;
        }

        public Human(String firstName, boolean sex, double height) {
            this.firstName = firstName;
            this.sex = sex;
            this.height = height;
        }

        public Human(boolean sex, double height) {
            this.sex = sex;
            this.height = height;
        }

        public Human() {
        }
    }
}
