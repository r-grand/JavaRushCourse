package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> listOfArrays = new ArrayList<>();
        listOfArrays.add(new int[] {5, 6, 3, 2, -6});
        listOfArrays.add(new int[] {-9, 12});
        listOfArrays.add(new int[] {800, -203, 16, 84});
        listOfArrays.add(new int[] {19, 27, -76, 586, -1, -100, 75});
        listOfArrays.add(new int[] {});
        return listOfArrays;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
