package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
	public static boolean checkTelNumber(String telNumber) {
		if (telNumber == null || telNumber.equals("")) {
			return false;
		}
		
		if (telNumber.startsWith("+") && telNumber.matches("^([^\\d]?\\d[^\\d]?){12}$")) {
			if (!telNumber.matches("^.{2,4}(\\(\\d{3}\\))?([^-()]+-[^-()]+){0,2}(\\d+)?\\d$")) {
				return false;
			}
			if (!telNumber.matches("^[^a-zA-Zа-яА-Я]+$")) {
				return false;
			}
			
			return true;
		} else if ((telNumber.substring(0, 1).matches("\\d") || telNumber.startsWith("(")) && telNumber.matches("^([^\\d]?\\d[^\\d]?){10}$")) {
			if (!telNumber.matches("^(\\(\\d{3}\\))?([^-()]+-[^-()]+){0,2}(\\d+)?\\d$")) {
				return false;
			}
			if (!telNumber.matches("^[^a-zA-Zа-яА-Я]+$")) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String[] test = {
				"+380501234567",
				"+38(050)1234567",
				"+38050123-45-67",
				"050123-4567",
				"+38)050(1234567",
				"+38(050)1-23-45-6-7",
				"050ххх4567",
				"050123456",
				"0501234560",
				"(0)501234567",
				"(123)4567890",
				null
		};
		for (String s : test) {
			System.out.println(checkTelNumber(s));
		}
	}
}
