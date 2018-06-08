package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "мама", "мыла", "раму");
        int max = list.size();
        for (int i = 0; i < max; i++) {
            list.add(i*2+1, "именно");
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
