package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
                FileWriter fileWriter = new FileWriter(args[1])) {

            String line;
            boolean first = true;
            while ((line = bufferedReader.readLine()) != null) {
                String tmp[] = line.split(" ");

                for (String s : tmp) {
                    if (s.length()>6){
                        if (first){
                            first = false;
                        }
                        else {
                            fileWriter.write(",");
                        }
                        fileWriter.write(s);
                    }
                }
               // first = true;
               // fileWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
