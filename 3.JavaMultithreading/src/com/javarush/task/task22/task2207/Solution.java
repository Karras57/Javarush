package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();

        List<String> stringList=  Files.lines(Paths.get(fileName))
                .collect(ArrayList::new,(list, line)-> Collections.addAll(list, line.replace(String.valueOf('\ufeff'), "").split(" ")), ArrayList::addAll);

//        List<String> stringList=  new ArrayList<>();
//        BufferedReader reader = new BufferedReader(new FileReader(fileName));
//        String line;
//        while ((line = reader.readLine())!=null){
//            stringList.addAll(Arrays.asList(line.replace(String.valueOf('\ufeff').trim(), "").split(" ")));
//        }


        //StringBuilder sb;// = new StringBuilder();
        mark: for (int i = 0; i < stringList.size(); i++) {
            String word = stringList.get(i);
            if (word.isEmpty()) continue ;
            //проверим, что этого слова еще нет в списке
            for (Pair pair : result) {
                if (pair.first.equals(word) || pair.second.equals(word)) continue mark;
            }

            //или сразу найдем пару"тор"
            String reverse = new StringBuilder(word).reverse().toString();

            for (int j = i+1; j < stringList.size(); j++) {
                if (stringList.get(j).equals(reverse)){
                    result.add(new Pair(word, reverse));
                    break;
                }
            }

        }
        System.out.println(result);
    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
