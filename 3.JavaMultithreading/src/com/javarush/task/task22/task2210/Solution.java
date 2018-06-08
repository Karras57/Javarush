package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

        getTokens("level22.lesson13.task01", ".");

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        int lenth = tokenizer.countTokens();
        String[] result = new String [lenth];
        for (int i = 0; i <lenth ; i++) {
            result[i] = tokenizer.nextToken();
        }
//        for (String s : result) {
//            System.out.println(s);
//        }
        return result;
    }
}
