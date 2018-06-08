package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String stopSlovo = "сумма";
        double s = 0;
        String temp;
        while (true){
            temp = reader.readLine();
            if (stopSlovo.equals(temp)){
                System.out.println(s);
                break;
            }
            else{
                s+= Double.parseDouble(temp);
            }
        }
    }
}
