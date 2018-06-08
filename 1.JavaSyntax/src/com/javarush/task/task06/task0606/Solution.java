package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        for (int i = 0; i < text.length(); i++) {
            int temp = Integer.parseInt(text.substring(i,i+1));
            if (temp%2 == 0 && (temp!=0)){
                even++;
            }
            else {
                odd++;
            }
        }
        System.out.println("Even: "+even + " Odd: "+ odd);
    }
}
