package com.javarush.task.task06.task0605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Контролируем массу тела
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.calculateMassIndex(weight, height);
    }

    public static class Body {
        public static void calculateMassIndex(double weight, double height) {
            double imt = weight / (height * height);
            System.out.println(imt < 18.5 ? "Недовес: меньше чем 18.5" : 18.5 <= imt && imt < 25 ? "Нормальный: между 18.5 и 25" : 25 <= imt && imt < 30 ? "Избыточный вес: между 25 и 30" : 30 <= imt ? "Ожирение: 30 или больше" : "");
            /*
            if (imt < 18.5)
                System.out.println("Недовес: меньше чем 18.5");
            else if (18.5 <= imt && imt < 25)
                System.out.println("Нормальный: между 18.5 и 25");
            else if (25 <= imt && imt < 30)
                System.out.println("Избыточный вес: между 25 и 30");
            else if (30 <= imt)
                System.out.println("Ожирение: 30 или больше");
*/
        }
    }
}
