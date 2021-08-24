package com.javarush.task.task12.task1217;

/* 
Лететь, бежать и плыть
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public static String fly() {
            return "I can fly!";
        }
    }
    public interface CanRun {
        public static String run() {
            return "I can run!";
        }
    }
    public interface CanSwim {
        public static String swim() {
            return "I can swim!";
        }
    }
}
