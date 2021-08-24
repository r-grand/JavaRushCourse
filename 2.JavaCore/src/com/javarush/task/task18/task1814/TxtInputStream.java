package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        if ((fileName.toCharArray()[fileName.toCharArray().length - 4]) != '.'
                || (fileName.toCharArray()[fileName.toCharArray().length - 3]) != 't'
                || (fileName.toCharArray()[fileName.toCharArray().length - 2]) != 'x'
                || (fileName.toCharArray()[fileName.toCharArray().length - 1]) != 't') {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) {
    }
}

