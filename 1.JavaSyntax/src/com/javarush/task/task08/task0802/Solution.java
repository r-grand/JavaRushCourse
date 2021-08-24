package com.javarush.task.task08.task0802;

import java.util.HashMap;
import java.util.Map;

/* 
Map из 10 пар
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> botany = new HashMap<>();
        botany.put("арбуз", "ягода");
        botany.put("банан", "трава");
        botany.put("вишня", "ягода");
        botany.put("груша", "фрукт");
        botany.put("дыня", "овощ");
        botany.put("ежевика", "куст");
        botany.put("жень-шень", "корень");
        botany.put("земляника", "ягода");
        botany.put("ирис", "цветок");
        botany.put("картофель", "клубень");

        for (Map.Entry<String, String> map :
                botany.entrySet()) {
            String key = map.getKey();
            String value = map.getValue();
            System.out.println(key + " - " + value);
        }
    }
}
