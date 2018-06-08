package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try(
//        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
//        BufferedReader reader2 = new BufferedReader(new FileReader(reader.readLine()))){

            BufferedReader reader1 = new BufferedReader(new FileReader(args[0]));
        BufferedReader reader2 = new BufferedReader(new FileReader(args[1]))){
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            while (reader1.ready()){
                list1.add(reader1.readLine());
            }
            while (reader2.ready()){
                list2.add(reader2.readLine());
            }
            int counter1 = 0, counter2 = 0, counter = 0;
            int max = Math.max(list1.size(), list2.size());
            try {
                while (counter+counter1<max && counter+counter2<max){

                    if (list1.get(counter+counter1).equals(list2.get(counter+counter2))){
                        lines.add(new LineItem(Type.SAME, list1.get(counter+counter1)));
                        counter++;
                    }
                    else {
                        if (list1.get(counter+counter1).equals(list2.get(counter+counter2+1))){
                            //добавлено во 2 сп
                            counter2++;
                            lines.add(new LineItem(Type.ADDED, list2.get(counter+counter2)));
                        }else if (list1.get(counter+counter1+1).equals(list2.get(counter+counter2))){
                            //удалено
                            counter1++;
                            lines.add(new LineItem(Type.REMOVED, list1.get(counter+counter1)));
                        }
                    }
                }
            } catch (Exception ignored) {
                System.out.println(ignored.getMessage());
            }
            finally {
                lines.forEach(x-> System.out.println(x.type +" "+ x.line));
                System.out.println(lines);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

    }
}
