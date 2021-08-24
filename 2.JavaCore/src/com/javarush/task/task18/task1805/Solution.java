package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fis = new FileInputStream(scanner.nextLine());
        scanner.close();
        List<Integer> list = new ArrayList<>();
    
        while (fis.available() > 0) {
            list.add(fis.read());
        }
        fis.close();
    
        Collections.sort(list);
    
        System.out.print(list.get(0) + " ");
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i - 1)) {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}

