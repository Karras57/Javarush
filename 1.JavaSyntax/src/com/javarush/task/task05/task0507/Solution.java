package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        boolean read = true;
        Scanner scanner  = new Scanner(System.in);
        double sum = 0;
        int count = 0;
        while (read){
            double input = scanner.nextDouble();
            if (input!=-1){
                sum+=input;
                count++;
            }
            else {
                read = false;
            }
        }
        System.out.println(sum/count);
    }
}

