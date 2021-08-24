package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> mapSalary = new HashMap<>();
        mapSalary.put("Гранд", 2500);
        mapSalary.put("Штукерт", 800);
        mapSalary.put("Иванов", 450);
        mapSalary.put("Грищенко", 2000);
        mapSalary.put("Загорская", 1500);
        mapSalary.put("Кондюрин", 800);
        mapSalary.put("Суханов", 0);
        mapSalary.put("Крюгер", 50);
        mapSalary.put("Симороз", 1200);
        mapSalary.put("Малахова", 300);
        return mapSalary;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Map<String, Integer> copy = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair :
                copy.entrySet()) {
            if (pair.getValue() < 500)
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}