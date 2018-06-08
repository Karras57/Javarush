package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean read = true;
        double sum = 0;
        while (read){
            Double temp= Double.parseDouble(reader.readLine());
            sum+= temp;
            if (temp ==-1){
                System.out.println(sum);
                read = false;
            }
        }
    }
}
