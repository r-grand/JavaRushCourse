package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    int test;
    String temp;
    
    private Solution(int test) {
        this.test = test;
    }
    
    Solution() {
    }
    
    protected Solution(String temp) {
        this.temp = temp;
    }
    
    public Solution(int test, String temp) {
        this.test = test;
        this.temp = temp;
    }
    
}

