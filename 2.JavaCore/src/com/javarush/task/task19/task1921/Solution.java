package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
	public static final List<Person> PEOPLE = new ArrayList<>();
	
	public static void main(String[] args) throws IOException, ParseException {
		try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
			while (reader.ready()) {
				String[] line = reader.readLine().split(" ");
				StringBuilder name = new StringBuilder();
				StringBuilder date = new StringBuilder();
				for (String check : line) {
					try {
						if (Integer.parseInt(check) > 0) date.append(check).append(" ");
					} catch (NumberFormatException e) {
						name.append(check).append(" ");
					}
				}
				String personName = name.toString().trim();
				String personDate = date.toString().trim();
				SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
				Date personBirthDate = formatter.parse(personDate);
				PEOPLE.add(new Person(personName, personBirthDate));
			}
		}
	}
}
