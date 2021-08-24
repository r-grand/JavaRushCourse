package com.javarush.task.task16.task1615;

/* 
Аэропорт
*/

public class Solution {
    public static class Clock implements Runnable {
        public void run() {
            Thread current = Thread.currentThread();
            
            while (!current.isInterrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Tik");
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        Clock clock = new Clock();
        Thread clockThread = new Thread(clock);
        clockThread.start();
        
        Thread.sleep(10000);
        clockThread.interrupt();
    }
}