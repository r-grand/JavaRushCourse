package com.javarush.task.task35.task3509;

import java.util.*;

/* 
Collections & Generics
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList<T> newArrayList = new ArrayList<>();
        Collections.addAll(newArrayList, elements);
        return newArrayList;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet<T> newHashSet = new HashSet<>();
        Collections.addAll(newHashSet, elements);
        return newHashSet;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //напишите тут ваш код
        HashMap<K, V> newHashMap = new HashMap<>();
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < keys.size(); i++) {
            newHashMap.put(keys.get(i), values.get(i));
        }
        return newHashMap;
    }
}
