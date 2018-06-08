package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
       // String  fileName = "d:\\1C\\20180422\\1.txt";
        List<String> stringList=  Files.lines(Paths.get(fileName))
                .collect(ArrayList::new,(list, line)-> Collections.addAll(list, line.replace(String.valueOf('\ufeff'), "").split(" ")), ArrayList::addAll);


        String[] tmp =  stringList.toArray(new String[0]);
        StringBuilder result = getLine(tmp);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        int[] wordsUsed = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            if (sb.length()==0){
                sb.append(words[i]);
                wordsUsed[i]=1;
            }
            for (int j = 0; j < words.length; j++) {
                if (wordsUsed[j]==1) continue;
                if (sb.substring(sb.length()-1).toUpperCase().equals(words[j].substring(0,1).toUpperCase())){
                    sb.append(" ").append(words[j]);
                    wordsUsed[j]= 1;
                } else if (sb.substring(0,1).toUpperCase().equals(words[j].substring(words[j].length()-1).toUpperCase())){
                    sb.insert(0, " ").insert(0,words[j]);
                    wordsUsed[j]= 1;
                }
            }

            //если к слову не нашлось пары, нужно начинать с другого
            if (sb.length() == words[i].length()){
                sb.setLength(0);
                wordsUsed[i]=0;
            }
        }
        for (int i = 0; i < wordsUsed.length; i++) {
            if (wordsUsed[i]!=1){
                sb.append(" ").append(words[i]);
            }
        }
        return sb;
    }
}
