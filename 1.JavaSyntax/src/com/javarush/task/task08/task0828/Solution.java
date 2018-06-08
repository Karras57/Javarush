package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Locale locale = Locale.ENGLISH;
        for (int i = 0; i < 12; i++) {
            map.put(Month.of(i+1).getDisplayName(TextStyle.FULL, locale), i+1);
        }
//        map.entrySet().forEach(x-> System.out.println(x.getKey() +" - "+ x.getValue()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String  month = reader.readLine();
        System.out.printf("%s is the %d month", month, map.get(month));

    }
}
