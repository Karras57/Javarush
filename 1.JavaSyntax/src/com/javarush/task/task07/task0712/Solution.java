package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }
        int longIndex = 0;
        int shortIndex = 0;
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length()>strings.get(longIndex).length()) longIndex = i;
            if (strings.get(i).length()<strings.get(shortIndex).length()) shortIndex = i;
        }
        System.out.println(strings.get(Math.min(longIndex, shortIndex)));

    }
}
