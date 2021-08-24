package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(5);
        integerSet.add(12);
        integerSet.add(15);
        integerSet.add(6);
        integerSet.add(2);
        integerSet.add(1);
        integerSet.add(8);
        integerSet.add(13);
        integerSet.add(9);
        integerSet.add(18);
        integerSet.add(3);
        integerSet.add(4);
        integerSet.add(7);
        integerSet.add(25);
        integerSet.add(10);
        integerSet.add(96);
        integerSet.add(48);
        integerSet.add(24);
        integerSet.add(14);
        integerSet.add(56);
        
        return integerSet;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
//        Set<Integer> integerSet = new HashSet<>();
//        integerSet.addAll(set);
//        for (int i :
//                integerSet) {
//            if (i > 10)
//                set.remove(i);
//        }
        set.removeIf(i -> i > 10);
        return set;
    }

    public static void main(String[] args) {
        Set<Integer> set = createSet();
        removeAllNumbersGreaterThan10(set);
        System.out.println(set);
    }
}
