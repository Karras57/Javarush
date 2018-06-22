package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        raf.seek(Integer.parseInt(args[1]));
        String text = args[2];
        byte[] buffer = new byte[text.length()];
        raf.read(buffer, 0, text.length());
        raf.seek(raf.length());
        if (text.equals(new String(buffer))){
            raf.write("true".getBytes());
        } else {
            raf.write("false".getBytes());
        }
        raf.close();
    }
}
