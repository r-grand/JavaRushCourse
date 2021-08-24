package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
	public static void main(String... args) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            raf.seek(Long.parseLong(args[1]));
            byte[] text = args[2].getBytes();
            byte[] readText = new byte[text.length];
            raf.read(readText, 0, text.length);
            raf.seek(raf.length());
            if (Arrays.equals(text, readText)) {
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }
        }
    }
}
