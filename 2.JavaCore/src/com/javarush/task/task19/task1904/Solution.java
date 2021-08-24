package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {
	
	public static void main(String[] args) {
	
	}
	
	public static class PersonScannerAdapter implements PersonScanner {
		private final Scanner fileScanner;
        
        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }
        
        @Override
        public Person read() throws IOException, ParseException {
            String data = fileScanner.nextLine();
            String[] elements = data.split(" ");
			String lastName = elements[0];
			String firstName = elements[1];
			String middleName = elements[2];
			String date = elements[3] + "-" + elements[4] + "-" + elements[5];
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date birthDate = sdf.parse(date);
			return new Person(firstName, middleName, lastName, birthDate);
        }
        
        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
