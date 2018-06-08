package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = 3;
        int[] mas = new int[n];
        for (int i = 0; i < n; i++) {
            mas[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n-1 ; j++) {
                if (mas[j]>mas[j+1]){
                    int temp  = mas[j];
                    mas[j] = mas[j+1];
                    mas[j+1] = temp;
            }

            }
        }
        System.out.println(mas[1]);
    }
}
