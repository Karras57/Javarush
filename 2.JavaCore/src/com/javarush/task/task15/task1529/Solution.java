package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Flyable result;

    public static void reset() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        //Flyable result;
        if ("helicopter".equals(line)){
           result = new Helicopter();
        }
        else if ("plane".equals(line)){
            result = new Plane(Integer.parseInt(reader.readLine()));
        }
        reader.close();
        //add your code here - добавьте код тут
    }
}
