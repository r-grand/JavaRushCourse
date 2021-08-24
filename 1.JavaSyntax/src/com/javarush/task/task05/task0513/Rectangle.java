package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    private int top;
    private int left;
    private int width = 0;
    private int height = width;

    public void initialize(int left, int top, int width, int height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }
    public void initialize(int left, int top) {
        this.left = left;
        this.top = top;
    }
    public void initialize(int left, int top, int width) {
        this.left = left;
        this.top = top;
        this.width = width;
    }
    public void initialize(Rectangle copy) {
        copy.left = left;
        copy.top = top;
        copy.width = width;
        copy.height = height;
    }

    public static void main(String[] args) {

    }
}
