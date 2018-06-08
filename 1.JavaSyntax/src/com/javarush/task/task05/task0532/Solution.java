package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int maximum = 0;
        boolean first = true;
        for (int i = 0; i <n ; i++) {
            int temp = Integer.parseInt(reader.readLine());
           maximum = first? temp : Math.max(maximum, temp);
           first = false;
            }

        System.out.println(maximum);
    }
}
