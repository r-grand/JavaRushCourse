package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        char[] stringToCharArray = string.toCharArray();
        List<Character> listVowels = new ArrayList<>();
        List<Character> listConsonants = new ArrayList<>();
        for (char chars :
                stringToCharArray) {
            if (isVowel(chars) == true && chars != ' ') {
                listVowels.add(chars);
            }
            if (isVowel(chars) == false && chars != ' ') {
                listConsonants.add(chars);
            }
        }
        for (int i = 0; i < listVowels.size(); i++) {
            System.out.print(listVowels.get(i).toString() + ' ');
        }
        System.out.println();
        for (int i = 0; i < listConsonants.size(); i++) {
            System.out.print(listConsonants.get(i).toString() + ' ');
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char character) {
        character = Character.toLowerCase(character);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char vowel : vowels) {  // ищем среди массива гласных
            if (character == vowel) {
                return true;
            }
        }
        return false;
    }
}