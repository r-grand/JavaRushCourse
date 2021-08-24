package com.javarush.task.task16.task1610;

/* 
Расставь вызовы методов join()
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread.sleep(500);
            System.out.print("Tik");
            Thread.sleep(500);
            System.out.print(" - Tak ");
        }
    }
}