package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    private static int maxStop(int a, int b){
        if (a==-1){
            return b;
        }
        else return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
     //   url = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
     //   url = url.replaceAll("^.*?\\?","");
        System.out.println(url);
      //  url = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        int requestStart = url.indexOf('?')+1;
        List<String> list = new ArrayList<>();
        int stop1;

        int stop2;
        int next;
        String tmp;
        String objectValue = "";
        if (requestStart>0){



            while (true) {
                //до первого встречного = или & или доконца строки
                stop1 = url.indexOf('=', requestStart);
                stop2 = url.indexOf('&', requestStart);
                stop1 = maxStop(stop1, url.length()-1);
                stop2 = maxStop(stop2, url.length()-1);
                next = Math.min(Math.min(stop1, stop2) , url.length()-1);
                tmp = url.substring(requestStart, next);
                list.add(tmp);
                if (tmp.equals("obj")){
                    objectValue = url.substring(requestStart+4, stop2);

                }
                requestStart = url.indexOf('&', requestStart)+1;
                if (requestStart==0) {
                    break;
                }
            }
        }
        list.forEach(x-> System.out.print(x+" "));

        if (!objectValue.isEmpty()) {
            System.out.println();
            if (objectValue.matches("[+-]?\\d+")||objectValue.matches("[+-]?\\d+\\.\\d*")){
                alert(Double.parseDouble(objectValue));

            }
            else{
                alert(objectValue);
            }
        }

      //  System.out.println(objectValue);
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
