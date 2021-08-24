package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
	public static void main(String[] args) {
		//you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
		//вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
		try {
			File yourFile = new File("d:\\idea\\save.dat");
			OutputStream outputStream = new FileOutputStream(yourFile);
			InputStream inputStream = new FileInputStream(yourFile);
			
			JavaRush javaRush = new JavaRush();
			//initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
			
			User uRomanGrand = new User();
			uRomanGrand.setFirstName("Roman");
			uRomanGrand.setLastName("Grand");
			uRomanGrand.setBirthDate(new Date(100));
			uRomanGrand.setMale(true);
			uRomanGrand.setCountry(User.Country.RUSSIA);
			
			User uTarasMul = new User();
			uTarasMul.setFirstName("Taras");
			uTarasMul.setLastName("Mul");
			uTarasMul.setBirthDate(new Date(200));
			uTarasMul.setMale(true);
			uTarasMul.setCountry(User.Country.UKRAINE);
			
			User uAlishaBock = new User();
			uAlishaBock.setFirstName("Alisha");
			uAlishaBock.setLastName("Bock");
			uAlishaBock.setBirthDate(new Date(300));
			uAlishaBock.setMale(false);
			uAlishaBock.setCountry(User.Country.OTHER);

			javaRush.users.add(uRomanGrand);
			javaRush.users.add(uTarasMul);
			javaRush.users.add(uAlishaBock);
			
			javaRush.save(outputStream);
			outputStream.flush();
			
			JavaRush loadedObject = new JavaRush();
			loadedObject.load(inputStream);
			//here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
			System.out.println(javaRush.hashCode() == loadedObject.hashCode());
			for (User user : loadedObject.users) {
				System.out.println(user.getFirstName());
				System.out.println(user.getLastName());
				System.out.println(user.getBirthDate());
				System.out.println(user.isMale());
				System.out.println(user.getCountry());
			}
			
			outputStream.close();
			inputStream.close();
			
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Oops, something is wrong with my file");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Oops, something is wrong with the save/load method");
		}
	}
	
	public static class JavaRush {
		public List<User> users = new ArrayList<>();
		
		public void save(OutputStream outputStream) throws Exception {
			PrintWriter printWriter = new PrintWriter(outputStream);
			if (this.users.size() > 0) {
				for (User user : users) {
					printWriter.println(user.getFirstName());
					printWriter.println(user.getLastName());
					printWriter.println(user.getBirthDate().getTime());
					printWriter.println(user.isMale());
					printWriter.println(user.getCountry());
				}
			}
			printWriter.flush();
		}
		
		public void load(InputStream inputStream) throws Exception {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			while (reader.ready()) {
				User user = new User();
				user.setFirstName(reader.readLine());
				user.setLastName(reader.readLine());
				user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
				user.setMale(Boolean.parseBoolean(reader.readLine()));
				String checkCountry = reader.readLine();
				if (checkCountry.equals("RUSSIA")) {
					user.setCountry(User.Country.RUSSIA);
				} else if (checkCountry.equals("UKRAINE")) {
					user.setCountry(User.Country.UKRAINE);
				} else user.setCountry(User.Country.OTHER);
				this.users.add(user);
			}
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			
			JavaRush javaRush = (JavaRush) o;
			
			return users != null ? users.equals(javaRush.users) : javaRush.users == null;
			
		}
		
		@Override
		public int hashCode() {
			return users != null ? users.hashCode() : 0;
		}
	}
}
