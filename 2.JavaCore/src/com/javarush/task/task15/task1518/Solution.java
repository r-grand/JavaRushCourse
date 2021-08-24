package com.javarush.task.task15.task1518;

/* 
Статики и котики
*/

public class Solution {
    public static void main(String[] args) {
        howWeUseLabels(true);
        System.out.println();
        howWeUseLabels(false);
    }
    public static void howWeUseLabels(boolean bool) {
        firstBlock:{
            secondBlock:{
                thirdBlock:{
                    System.out.println("We will see it always");
                    if(bool) {
                        break secondBlock;
                    }
                    System.out.println("We won't see it if bool == true");
                }
                System.out.println("We won't see it if bool == true");
            }
            System.out.println("We will see it always");
        }
    }
}