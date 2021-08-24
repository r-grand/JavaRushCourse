package com.javarush.task.task12.task1210;

/* 
Три метода и максимум
*/

public class Solution {
    public static void main(String[] args) {
    
    }
    
}

abstract class AbstractTest {
    public abstract int max(int a, int b);
    public abstract long max(long a, long b);
    public abstract double max(double a, double b);
}

class Test extends AbstractTest {
    
    @Override
    public int max(int a, int b) {
        return 0;
    }
    
    @Override
    public long max(long a, long b) {
        return 0;
    }
    
    @Override
    public double max(double a, double b) {
        return 0;
    }
}
