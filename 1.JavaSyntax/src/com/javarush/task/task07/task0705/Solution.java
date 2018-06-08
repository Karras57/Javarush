package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = new int[20];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }
        int[] mas1 = new int[10];
        int[] mas2 = new int[10];
        int half = array.length/2;
        for (int i = 0; i < array.length; i++) {
            if (i<half){
                mas1[i] = array[i];
            }
            else{
                mas2[i-half] = array[i];
            }
        }
        for (int i = 0; i < mas2.length; i++) {
            System.out.println(mas2[i]);
        }

    }
}
