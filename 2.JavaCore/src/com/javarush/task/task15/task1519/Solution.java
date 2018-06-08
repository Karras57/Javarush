package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int tmp;
        while (!(line = reader.readLine()).equals("exit")){
            try {
                if (line.indexOf('.')>-1){
                    print(Double.parseDouble(line));
                    continue;
                }

                tmp = Integer.parseInt(line);
                if (tmp>0&& tmp<128){
                    print((short)tmp);
                    continue;
                }
                else if (tmp<=0 ||tmp>=128){
                    print((Integer) tmp);
                    continue;
                }
            } catch (NumberFormatException e) {
                // e.printStackTrace();
            }
            print(line);
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
