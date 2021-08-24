package com.javarush.task.task05.task0532;


/*
Задача по алгоритмам Ӏ Java Syntax: 5 уровень, 12 лекция
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		String mercury = new String("Меркурий");
		String venus = new String("Венера");
		String earth = new String("Земля");
		String mars = new String("Марс");
		String jupiter = new String("Юпитер");
		String saturn = new String("Сатурн");
		String uranus = new String("Уран");
		String neptune = new String("Нептун");

		ArrayList<String> solarSystemPart1 = new ArrayList<>(Arrays.asList(mercury, venus, earth, mars));
		ArrayList<String> solarSystemPart2 = new ArrayList<>();
		solarSystemPart2.add(jupiter);
		solarSystemPart2.add(saturn);
		solarSystemPart2.add(uranus);
		solarSystemPart2.add(mars);

		System.out.println(Collections.disjoint(solarSystemPart1, solarSystemPart2));

		double min = Double.MIN_VALUE;
		System.out.println(min);

	}
}