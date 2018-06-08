package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = 5;
        int[] mas = new int[n];
        for (int i = 0; i < n; i++) {
            mas[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n-i-1 ; j++) {
                if (mas[j]> mas[j+1]) {
                    int temp = mas[j];
                    mas[j] = mas[j+1];
                    mas[j+1] = temp;
                }
            }

        }
        for (int i = 0; i < n; i++) {
            System.out.println(mas[i]);
        }
    }
}
