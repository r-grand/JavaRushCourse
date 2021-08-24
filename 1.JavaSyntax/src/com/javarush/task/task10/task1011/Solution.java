package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

import java.util.ArrayList;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        String text = "Я не хочу изучать Java, я хочу большую зарплату";
        Date date = new Date();
        char[] chars = text.toCharArray();
        ArrayList<Character> characterList = new ArrayList<>();
        for (char temp :
                chars) {
            characterList.add(temp);
        }
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < characterList.size(); j++) {
                System.out.print(characterList.get(j));
            }
            System.out.println();
            characterList.remove(0);
        }
        Date newDate = new Date();
        System.out.println(newDate.getTime() - date.getTime());
    }
}