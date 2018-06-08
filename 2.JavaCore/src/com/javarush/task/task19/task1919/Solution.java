package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        new FileReader(args[0]).close();
        TreeMap<String, Double > tree =
                Files.lines(Paths.get(args[0]))
               // Files.lines(Paths.get(args[0]), Charset.forName("Cp1251"))
                .map(x-> x.split(" "))
               // .peek(x->System.out.print(x[0]))
                .collect(TreeMap::new,
                        (treeMap, s) -> treeMap.merge(s[0],Double.parseDouble(s[1]),(value,newValue)->value+newValue),
                        ((treeMap1, treeMap2) -> treeMap2.forEach((k,v)-> treeMap1.merge(k,v+1,((oldValue, newValue)->oldValue+ newValue)))));

        tree.forEach((k,v)-> System.out.println(k+" "+ v));
        //System.out.println(tree);

    }
}
