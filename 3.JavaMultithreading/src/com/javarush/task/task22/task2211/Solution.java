package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        FileReader fileReader = new FileReader(args[0]);
//        fileReader.
        FileInputStream streamReader = new FileInputStream(args[0]);
        FileOutputStream streamWriter = new FileOutputStream(args[1]);
        byte[] buffer = new byte[60000];
        int count;
        while (streamReader.available()>0){
            count = streamReader.read(buffer);
            String tmp = new String(buffer, 0, count, Charset.forName("Windows-1251"));
            streamWriter.write(tmp.getBytes(Charset.forName("UTF-8")));
        }
    }
}
