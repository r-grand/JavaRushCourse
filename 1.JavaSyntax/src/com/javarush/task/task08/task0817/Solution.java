package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
	public static Map<String, String> createMap() {
		Map<String, String> peopleDatabase = new HashMap<>();
		peopleDatabase.put("Гранд", "Роман");
		peopleDatabase.put("Иванов", "Денис");
		peopleDatabase.put("Штукерт", "Андрей");
		peopleDatabase.put("Варнаков", "Сергей");
		peopleDatabase.put("Арляпова", "Надежда");
		peopleDatabase.put("Загорская", "Ольга");
		peopleDatabase.put("Бабенко", "Александр");
		peopleDatabase.put("Медведев", "Сергей");
		peopleDatabase.put("Суханов", "Илья");
		peopleDatabase.put("Кондюрин", "Антон");
		return peopleDatabase;
	}

	public static void removeTheFirstNameDuplicates(Map<String, String> map) {
		Map<String, String> copy1 = new HashMap<>(map);
		Map<String, String> copy = new HashMap<>(map);
		for (Map.Entry<String, String> pair :
				copy.entrySet()) {
			String check = pair.getValue();
			copy1.remove(pair.getKey());
			Map<String, String> copy2 = new HashMap<>(copy1);
			for (String value :
					copy2.values()) {
				if (value.equals(check))
					removeItemFromMapByValue(map, value);
			}
		}
	}

	public static void removeItemFromMapByValue(Map<String, String> map, String value) {
		Map<String, String> copy = new HashMap<>(map);
		for (Map.Entry<String, String> pair : copy.entrySet()) {
			if (pair.getValue().equals(value)) {
				map.remove(pair.getKey());
			}
		}
	}

	public static void main(String[] args) {
//  Метод main проверяет правильность кода перед отправкой валидатору
/*
		Map<String, String> base = createMap();
		System.out.println(base);
		removeTheFirstNameDuplicates(base);
		System.out.println(base);
*/
	}
}
