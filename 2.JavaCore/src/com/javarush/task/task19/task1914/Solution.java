package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = byteArrayOutputStream.toString().trim();
        String[] resultArray = result.split(" ");
        int c = 0;
        switch (resultArray[1]){
            case "+":
                c = Integer.parseInt(resultArray[0]) + Integer.parseInt(resultArray[2]);
                break;
                case "-":
                c = Integer.parseInt(resultArray[0]) - Integer.parseInt(resultArray[2]);
                break;
                case "*":
                c = Integer.parseInt(resultArray[0]) * Integer.parseInt(resultArray[2]);
                break;
        }
        System.setOut(printStream);
        System.out.println(result+ " " + c);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

