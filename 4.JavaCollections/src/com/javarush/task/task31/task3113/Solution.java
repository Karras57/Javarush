package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.EnumSet;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        String directoryName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        Path directory = Paths.get(directoryName);
        if (Files.isRegularFile(directory)){
            System.out.printf("%s - не папка", directory);
            return;
        }
        SimpleFileVisitor<Path> myFileVisitor = new MyFileVisitor();
        Files.walkFileTree(directory, myFileVisitor);
      //  Files.walkFileTree(directory, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE, myFileVisitor);
        System.out.println(myFileVisitor);
    }
}
