package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    int top = 0;
    int left = 0;
    int width = 0;
    int height = 0;

    public Rectangle(int left, int top, int width, int height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }
    public Rectangle(int left, int top) {
        this.left = left;
        this.top = top;
    }
    public Rectangle(int left, int top, int width) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = width;
    }
    public Rectangle(Rectangle rectangle) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {

    }
}
