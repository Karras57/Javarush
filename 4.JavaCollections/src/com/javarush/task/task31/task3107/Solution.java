package com.javarush.task.task31.task3107;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {

            try {
                Path path = Paths.get(pathToFile);
               // DosFileAttributes attributes = Files.readAttributes(path, DosFileAttributes.class);
               // BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
//                boolean hidden = attributes.isHidden();
//                boolean executable = Files.isExecutable(path);
//                boolean directory = attributes.isDirectory();
//                boolean writable = !attributes.isReadOnly();
//
                boolean hidden = Files.isHidden(path);
                boolean executable = Files.isExecutable(path);
                boolean directory = Files.isDirectory(path);
                boolean writable = Files.isWritable(path);
                fileData = new ConcreteFileData(hidden,executable, directory, writable);
            }
            catch (Exception ex){
                fileData = new NullFileData(ex);
               // ex.printStackTrace();
            }

    }

    public FileData getFileData() {
        return fileData;
    }

    public static void main(String[] args) {
        new Solution("d:\\1C\\20180124\\testfile.txt");
    }
}
