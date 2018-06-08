package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException {
        new FileReader(args[0]).close();
        TreeMap<String, Double > tree =
                        Files.lines(Paths.get(args[0]))
                         //Files.lines(Paths.get(args[0]), Charset.forName("Cp1251"))
                        .map(x-> x.split(" "))
                        // .peek(x->System.out.print(x[0]))
                        .collect(TreeMap::new,
                                (treeMap, s) -> treeMap.merge(s[0],Double.parseDouble(s[1]),(value,newValue)->value+newValue),
                                ((treeMap1, treeMap2) -> treeMap2.forEach((k,v)-> treeMap1.merge(k,v+1,((oldValue, newValue)->oldValue+ newValue)))));
        Stream<Map.Entry<String, Double>> sortedStream = tree.entrySet().stream().sorted((entry1, entry2)->entry1.getValue().compareTo(entry2.getValue()));
        Double x= tree.entrySet().stream().max((entry1, entry2)->entry1.getValue().compareTo(entry2.getValue())).get().getValue();
        TreeSet<String > stringTreeSet =
        tree.entrySet().stream().filter(entry-> entry.getValue().equals(x)).collect( TreeSet::new, (treeSet, entry)->treeSet.add(entry.getKey()), TreeSet::addAll);
        //System.out.println(stringTreeSet);
        stringTreeSet.forEach(System.out::println);

        //tree.forEach((k,v)-> System.out.println(k+" "+ v));
        //System.out.println(tree);
    }
}
