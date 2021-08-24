package com.javarush.task.task18.task1810;

import java.io.*;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        while (new FileInputStream((new BufferedReader(new InputStreamReader(System.in))).readLine()).available() > 999) {
        }
        throw new DownloadException();
    }
    
    public static class DownloadException extends Exception {

    }
}
