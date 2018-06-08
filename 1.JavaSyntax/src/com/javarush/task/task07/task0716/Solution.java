package com.javarush.task.task07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лоза"); //1
        list.add("лира"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        for (int i = 0; i < list.size(); ) {
            String temp = list.get(i);
            if (temp.contains("р")&& temp.contains("л")){
                i++;
                continue;
            }
            if (temp.contains("р")){
                list.remove(i);
                continue;
            }
            if (temp.contains("л")){
                list.add(i+1, list.get(i));
                i+=2;
                continue;
            }
            i++;
        }
        return list;
    }
}