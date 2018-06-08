package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();

        reader.close();
        FileReader fileReader = new FileReader(fileName1);
        int count = 0;
        Pattern pattern = Pattern.compile("\\bworld\\b");

        reader = new BufferedReader(fileReader);
        String line;
        while ((line = reader.readLine())!=null){
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                count++;
                //System.out.println(matcher.start());
            }
        }


        fileReader.close();
        reader.close();
        System.out.println(count);

//        long tmp = Files.lines(Paths.get(fileName1)).mapToLong(x-> x.split("\\W").length).sum();
//        System.out.println(tmp);

    }
}
