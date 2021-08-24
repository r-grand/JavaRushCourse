package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human ded1 = new Human("Юра", true, 79);
        Human ded2 = new Human("Афиноген-мудак", true, 78);
        Human baba1 = new Human("Оля", false, 72);
        Human baba2 = new Human("Тоня", false, 72);
        Human papa = new Human("Юра", true, 79, ded2, baba2);
        Human mama = new Human("Таня", false, 52, ded1, baba1);
        Human kind1 = new Human("Рома", true, 33, papa, mama);
        Human kind2 = new Human("Денис", true, 31, papa, mama);
        Human kind3 = new Human("Аня", false, 20, papa, mama);

        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(baba1);
        System.out.println(baba2);
        System.out.println(papa);
        System.out.println(mama);
        System.out.println(kind1);
        System.out.println(kind2);
        System.out.println(kind3);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}