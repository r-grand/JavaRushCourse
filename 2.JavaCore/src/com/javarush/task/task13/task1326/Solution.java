package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        FileInputStream inputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(inputStream);
        int ints;
        ArrayList<Integer> integers = new ArrayList<>();
        
        while (scanner.hasNext()) {
            ints = scanner.nextInt();
            integers.add(ints);
        }
        
        inputStream.close();
        
        Collections.sort(integers);
        
        for (int i : integers) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
