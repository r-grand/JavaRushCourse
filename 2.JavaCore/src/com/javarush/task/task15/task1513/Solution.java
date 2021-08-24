package com.javarush.task.task15.task1513;

/*
Прибавка к зарплате
*/

public class Solution {
    public static void main(String[] args) {
        hackSalary(700);        //зарплата
    }
    
    public static void hackSalary(int salary) {
        int s = salary;
        System.out.println("Твоя зарплата составляет: " + (s +100) + " долларов в месяц.");
    }
}