package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
       // String fileName = "d:\\1C\\20180422\\1.txt";
        reader.close();

        BufferedReader fileReader =new BufferedReader(new FileReader(fileName));
        String bufer;
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = fileReader.readLine())!=null){
            sb.append(line);
        }
        fileReader.close();
        bufer = sb.toString();
        List<String> list = new ArrayList<>();
        findTags(bufer, args[0], list);
        list.forEach(System.out::println);
    }

    private static void findTags(String source, String tag, List<String> result){
        Pattern pattern = Pattern.compile("<"+tag+ " ?");
        Matcher matcher = pattern.matcher(source);
        int searchIndex = 0;
        while (matcher.find(searchIndex)){

            //нашли начал тега, найдем конец
            Pattern endPattern = Pattern.compile("</" + tag + ">");
            int start = matcher.start();
            Matcher endMatcher = endPattern.matcher(source.substring(start));

            //не найти мы не можем, но...
            List<String> tmp = new ArrayList<>();
            while (endMatcher.find()){
                if (matcher.find() && (matcher.start()< start+endMatcher.start())){
                    findTags(source.substring(matcher.start(), start+endMatcher.end()), tag, tmp);
                } else {
                    result.add(source.substring(start, start + endMatcher.end()));
                    result.addAll(tmp);
                    searchIndex = start+ endMatcher.end();
                    break;
                }
            }
        }
    }
}
