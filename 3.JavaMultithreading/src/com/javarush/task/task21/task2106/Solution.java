package com.javarush.task.task21.task2106;

import java.util.Date;
import java.util.Objects;

/* 
Ошибка в equals/hashCode
*/

public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution sol = (Solution) o;
        if (anInt != sol.anInt) return false;
        if (!(Objects.equals(string, sol.string))) return false;
        if (aDouble != sol.aDouble) return false;
        if (!(Objects.equals(date, sol.date))) return false;
        return Objects.equals(solution, sol.solution);
    }

    @Override
    public int hashCode() {
        int result;
        result = anInt;
        result = 31 * result + (string == null ? 0 : string.hashCode());
        result = 31 * result + (int) aDouble;
        result = 31 * result + (date == null ? 0 : date.hashCode());
        result = 31 * result + (solution == null ? 0 : solution.hashCode());
        return result;
    }

    public static void main(String[] args) {

    }
}
