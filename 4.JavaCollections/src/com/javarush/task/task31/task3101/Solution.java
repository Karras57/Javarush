package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length!=2) return;
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        File result = new File(resultFileAbsolutePath);
        File destinationFile = new File(result.getParent()+"/"+"allFilesContent.txt");//

        //для тестов
       // FileUtils.renameFile(destinationFile, result);

        if (FileUtils.isExist(destinationFile)){
            FileUtils.deleteFile(destinationFile);
        }
        FileUtils.renameFile(result, destinationFile);

        File directory = new File(path);
        List<File> list  = new ArrayList<>();
        doJob(directory, list);
        list.sort(Comparator.comparing(File::getName));

        FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);
        for (File file : list) {
            try (FileInputStream fileInputStream = new FileInputStream(file)){
                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
                fileOutputStream.write(buffer);
                fileOutputStream.write("\n".getBytes());
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fileOutputStream.close();

    }
    public static void doJob(File directory, List<File> list){
        for (File file : directory.listFiles()) {
            if (file.isDirectory()){
                doJob(file, list);
            } else if (file.length()<=50){
                list.add(file);
            }
        }
    }
}
