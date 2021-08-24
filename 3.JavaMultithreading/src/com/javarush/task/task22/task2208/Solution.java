package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", null);
        map.put("country", null);
        map.put("city", null);
        map.put("age", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sB = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null) {
                sB.append(pair.getKey()).append(" = '").append(pair.getValue()).append("' and ");
            }
        }
        if (sB.length() > 0) {
            sB.delete(sB.length() - 4, sB.length() - 1);
        }
        return sB.toString().trim();
    }
}
