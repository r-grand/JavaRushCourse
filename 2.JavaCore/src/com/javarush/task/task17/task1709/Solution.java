package com.javarush.task.task17.task1709;

/* 
Предложения
*/

public class Solution {
    public static class ThreadExample extends Thread {
        
        public ThreadExample() {
            this.start();
        }
        
        public void run() {
            
            System.out.println(Thread.currentThread().getName() + " уступает свое место другим");
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + " has finished executing.");
        }
        
        public static void main(String[] args) {
            new ThreadExample();
            new ThreadExample();
            new ThreadExample();
        }
    }
}