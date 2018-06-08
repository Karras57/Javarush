package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();


        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));


     //   Pattern pattern = Pattern.compile("\\b\\d+\\b");


        BufferedWriter bufferedWriter =   new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        String line;
        while ((line = fileReader.readLine())!=null){

                bufferedWriter.write(line.replaceAll("\\.", "!")+System.lineSeparator());

        }
        bufferedWriter.close();

        fileReader.close();
    }
}
