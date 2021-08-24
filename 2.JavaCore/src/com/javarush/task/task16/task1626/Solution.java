package com.javarush.task.task16.task1626;

/* 
Создание по образцу
*/

public class Solution {
    public static int number = 5;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new CountdownRunnable(), "Уменьшаем");
        t1.start();
        t1.join();
        new Thread(new CountUpRunnable(), "Увеличиваем").start();
    }


    public static class CountUpRunnable implements Runnable {
        private int countIndexDown = 1;

        public void run() {
            try {
                Thread.sleep(500);
                Thread.sleep(2000);
                while (true) {
                    System.out.println(toString());
                    countIndexDown += 1;
                    if (countIndexDown > Solution.number) return;
//                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
    
    
    public static class CountdownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
