package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> peopleDatabase = new HashMap<>();
        peopleDatabase.put("Гранд", "Роман");
        peopleDatabase.put("Иванов", "Денис");
        peopleDatabase.put("Штукерт", "Андрей");
        peopleDatabase.put("Варнаков", "Сергей");
        peopleDatabase.put("Арляпова", "Надежда");
        peopleDatabase.put("Загорская", "Ольга");
        peopleDatabase.put("Бабенко", "Александр");
        peopleDatabase.put("Медведев", "Сергей");
        peopleDatabase.put("Суханов", "Илья");
        peopleDatabase.put("Кондюрин", "Антон");
        return peopleDatabase;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int count = 0;
        for (String check : map.values()) {
            if (check.equals(name))
                count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int count = 0;
        for (String check : map.keySet()) {
            if (check.equals(lastName))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
//  Метод main проверяет правильность кода перед отправкой валидатору
/*
        Map<String, String> base = createMap();
        System.out.println(base);
        int howName = getCountTheSameFirstName(base, "Сергей");
        System.out.println(howName);
        int howLastName = getCountTheSameLastName(base, "Гранд");
        System.out.println(howLastName);
*/
    }
}
