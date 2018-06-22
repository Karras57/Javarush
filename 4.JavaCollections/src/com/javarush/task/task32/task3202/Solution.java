package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("d:\\1C\\20180422\\start\\namigoru.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();
        if (is==null) return sw;
        InputStreamReader reader = new InputStreamReader(is);
        char[] buffer = new char[1024];
        int count;
        while ((count = reader.read(buffer))>0){
            sw.write(buffer,0, count);
        }
        return sw;
    }
}