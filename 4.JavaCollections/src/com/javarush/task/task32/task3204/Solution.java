package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    private static Random random = new Random((long)(Math.random()*1000));

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
        for (int i = 0; i < 10; i++) {
            System.out.println(getPassword().toString());
        }
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream baous = new ByteArrayOutputStream();
        StringBuilder sb = new StringBuilder();
        while (!sb.toString().matches("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")) {
            sb.setLength(0);
            for (int i = 0; i < 8; i++) {
                sb.append(getSymbol());
            }
        }
        baous.write(sb.toString().getBytes());
        return baous;
    }

    private static char getSymbol() {
       // Random random = new Random(58);
        int type = random.nextInt(3);
        char result = 0;
        switch (type){
            case 0:
                result =  (char)(random.nextInt(26)+65);
                break;
            case 1:
                result =  (char)(random.nextInt(26)+97);
                break;
            case 2:
                result =  (char)(random.nextInt(10)+48);
                break;
        }
        return result;
    }
}