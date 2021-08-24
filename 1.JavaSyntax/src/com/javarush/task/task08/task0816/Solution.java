package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Смирнов", dateFormat.parse("MAY 1 2012"));
        map.put("Иванов", dateFormat.parse("SEPTEMBER 3 1989"));
        map.put("Штукерт", dateFormat.parse("FEBRUARY 25 1987"));
        map.put("Варнаков", dateFormat.parse("JANUARY 15 1951"));
        map.put("Арляпова", dateFormat.parse("DECEMBER 13 1955"));
        map.put("Загорская", dateFormat.parse("OCTOBER 4 1968"));
        map.put("Бабенко", dateFormat.parse("JULY 4 1980"));
        map.put("Медведев", dateFormat.parse("JUNE 19 1987"));
        map.put("Суханов", dateFormat.parse("DECEMBER 23 1988"));
        map.put("Кондюрин", dateFormat.parse("AUGUST 2 1994"));
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Map<String, Date> afterFunction = new HashMap<>();
        for (Map.Entry<String, Date> pair :
                map.entrySet()) {
            Date date = pair.getValue();
            String checkMonth = date.toString();
            String delimeter = " ";
            String[] stringsFromDate = checkMonth.split(delimeter);
            if (!stringsFromDate[1].equals("Jun") && !stringsFromDate[1].equals("Jul") && !stringsFromDate[1].equals("Aug"))
                afterFunction.put(pair.getKey(), pair.getValue());
        }
        map.clear();
        map.putAll(afterFunction);
    }

    public static void main(String[] args) throws ParseException {
//  Метод main проверяет правильность кода перед отправкой валидатору
/*
        Map<String, Date> base = createMap();
        System.out.println(base);
        removeAllSummerPeople(base);
        System.out.println(base);
*/
    }
}
