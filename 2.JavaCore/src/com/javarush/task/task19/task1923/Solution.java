package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
                FileWriter fileWriter = new FileWriter(args[1])) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String tmp[] = line.split(" ");
                for (String s : tmp) {
                    if (s.matches(".*\\d.*")){
                        fileWriter.write(s+ " ");
                    }
                }
            }
        }

    }
}

