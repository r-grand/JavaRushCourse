package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        Human child1 = new Human("Андрюша", true, 33);
        Human child2 = new Human("Толя", true, 22);
        Human child3 = new Human("Катя", false, 11);
        Human papa = new Human("Пётр", true, 55, child1, child2, child3);
        Human mama = new Human("Ольга", false, 44, child1, child2, child3);
        Human ded1 = new Human("Апостол", true, 99, papa);
        Human baba1 = new Human("Маруся", false, 77, papa);
        Human ded2 = new Human("Мандрит", true, 88, mama);
        Human baba2 = new Human("Викуся", false, 66, mama);

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
        System.out.println(papa);
        System.out.println(mama);
        System.out.println(ded1);
        System.out.println(baba1);
        System.out.println(ded2);
        System.out.println(baba2);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        List<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human... children) {
            this.name = name;
            this.sex = sex;
            this.age = age;

            Collections.addAll(this.children, children);
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
