package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        return Files.find(Paths.get(root), Integer.MAX_VALUE, ((path, basicFileAttributes) -> Files.isRegularFile(path)))
                .map(path -> path.normalize().toString())
                .collect(Collectors.toList());
    }

    public static List<String> getFileTreeQueue(String root) throws IOException {
        Queue<File> queue = new PriorityQueue<>();
        List<String > list = new ArrayList<>();
        queue.offer(new File(root));

        File file;
        while ((file = queue.poll())!=null){
            if (!file.isDirectory()) {
                list.add(file.getAbsolutePath());
            } else {
                Collections.addAll(queue, file.listFiles());
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException {

        getFileTree("d:\\1C\\20180422\\").forEach(System.out::println);
        //getFileTreeQueue("d:\\1C\\20180422\\").forEach(System.out::println);
//        System.out.println(getFileTree("d:\\1C\\20180422\\").sort(Comparator.naturalOrder()).equals(getFileTreeQueue("d:\\1C\\20180422\\").sort(Comparator.naturalOrder())));
//        System.out.println(getFileTree("d:\\1C\\20180422\\").size());
//        System.out.println(getFileTreeQueue("d:\\1C\\20180422\\").size());
    }
}
