package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> catMap = new HashMap<>();
        Cat boris = new Cat("Борис");
        Cat barsik = new Cat("Барсик");
        Cat brain = new Cat("Брайн");
        Cat cat = new Cat("Кот");
        Cat duck = new Cat("Утка");
        Cat eater = new Cat("Жрун");
        Cat fool = new Cat("Дурак");
        Cat full = new Cat("Полный");
        Cat fat = new Cat("Жирный");
        Cat gigant = new Cat("Гигант");
        catMap.put(boris.name, boris);
        catMap.put(barsik.name, barsik);
        catMap.put(brain.name, brain);
        catMap.put(cat.name, cat);
        catMap.put(duck.name, duck);
        catMap.put(eater.name, eater);
        catMap.put(fool.name, fool);
        catMap.put(full.name, full);
        catMap.put(fat.name, fat);
        catMap.put(gigant.name, gigant);

        return catMap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> catSet = new HashSet<>(map.values());
        return catSet;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }
}
