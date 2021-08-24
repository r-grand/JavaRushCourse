package com.javarush.task.task16.task1605;

import java.util.Date;

/* 
Поговорим о музыке
*/

public class Solution {
    public static void main(String[] args){
        Cat cat = new Cat();
        System.out.print(cat);
    }
}
class Cat{
    private String name;
    private int age;
    public Cat(){
        name = "Васька";
        age = 5;
    }
    public String toString(){
        return name + "-" + age;
    }
}