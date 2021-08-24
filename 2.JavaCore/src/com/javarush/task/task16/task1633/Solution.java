package com.javarush.task.task16.task1633;

/* 
Отдебажим все на свете
*/

public class Solution {
    public static OurUncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread();

        Thread threadA = new TestedThread("Нить 1");
        Thread threadB = new Thread(commonThread, "Нить 2");
    
        threadA.start();
        threadB.start();
        
        threadA.setUncaughtExceptionHandler(handler);
        threadB.setUncaughtExceptionHandler(handler);

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread() {
        }
    
        public TestedThread(String name) {
            super(name);
        }
    
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException("My exception message");
            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
        
    }
}
