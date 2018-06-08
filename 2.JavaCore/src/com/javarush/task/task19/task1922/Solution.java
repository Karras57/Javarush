package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String line;
        List<String > list = new ArrayList<>();

//        words.clear();
//        words.addAll(Arrays.asList("А","Б","В"));

        while ((line = bufferedReader.readLine())!=null){

            list.addAll(Arrays.asList(line.split(" ")));
            //treeSet = Arrays.asList(line.split(" "));

            list.retainAll(words);
            if (list.size()==2){
                System.out.println(line);
            }
            list.clear();
        }
        bufferedReader.close();

    }
}
