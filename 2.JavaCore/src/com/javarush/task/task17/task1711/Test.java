package com.javarush.task.task17.task1711;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test {
	public static void main(String[] args) throws Exception {
		//Создаем поток-чтения-байт-из-файла
		FileInputStream inputStream = new FileInputStream("d:/idea/2in1.txt");
		// Создаем поток-записи-байт-в-файл
		FileOutputStream outputStream = new FileOutputStream("d:/idea/result.txt");
		
		while (inputStream.available() > 0) //пока есть еще непрочитанные байты
		{
			int data = inputStream.read(); // прочитать очередной байт в переменную data
			outputStream.write(data); // и записать его во второй поток
		}
		
		inputStream.close(); //закрываем оба потока. Они больше не нужны.
		outputStream.close();
	}
}