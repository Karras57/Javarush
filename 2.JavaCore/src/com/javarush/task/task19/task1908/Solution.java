package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();


        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));


        Pattern pattern = Pattern.compile("\\b\\d+\\b");


        BufferedWriter bufferedWriter =   new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        String line;
        while ((line = fileReader.readLine())!=null){
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                bufferedWriter.write(matcher.group()+" ");
            }
        }
        bufferedWriter.close();

        fileReader.close();



        //List<String > treeSet = Files.lines(Paths.get(fileName1)).flatMap(x->Arrays.stream(x.split("\\s")).filter(y-> y.matches("\\d+"))).collect(Collectors.toList());






//       bufferedWriter.write(String.join(" ", treeSet));
//       bufferedWriter.close();
        //System.out.println(treeSet);

    }
}
