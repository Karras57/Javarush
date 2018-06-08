package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = new int[15];
        int even = 0;
        int odd = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }
        for (int i = 0; i < array.length; i++) {
            if (i%2 ==0){
                even+=array[i];
            }
            else{
                odd+=array[i];
            }

        }
        System.out.printf("В домах с %s номерами проживает больше жителей.", even>odd? "четными": "нечетными");

    }
}
