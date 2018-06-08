package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

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

            bufferedWriter.write(line.replaceAll("\\p{Punct}", "")+System.lineSeparator());

        }
        bufferedWriter.close();

        fileReader.close();
    }
    }
