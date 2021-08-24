package com.javarush.task.task15.task1515;

import java.util.InputMismatchException;
import java.util.Scanner;

/* 
Статики-2
*/

public class Solution {
    public static int A;
    public static int B;
    
    static {
        Scanner scanner = new Scanner(System.in);
        try {
            A = scanner.nextInt();
            B = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели неверное значение");
        }
        scanner.close();
    }

    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
