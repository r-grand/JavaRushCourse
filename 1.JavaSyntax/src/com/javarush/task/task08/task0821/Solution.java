package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        Map<String, String> result = new HashMap<>();
        result.put("Петров", "Василий");
        result.put("Иванов", "Геннадий");
        result.put("Гранд", "Роман");
        result.put("Ленин", "Василий");
        result.put("Смехов", "Вениамин");
        result.put("Иванов", "Владимир");
        result.put("Петров", "Павел");
        result.put("Козлов", "Олег");
        result.put("Иванов", "Максим");
        result.put("Ходусов", "Олег");

        return result;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
