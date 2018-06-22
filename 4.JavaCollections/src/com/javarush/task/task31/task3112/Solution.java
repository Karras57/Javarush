package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL urlU = new URL(urlString);
        InputStream inputStream = urlU.openStream();

        Path tmp = Files.createTempFile("tmpDownload",null);
        Files.copy(inputStream, tmp, StandardCopyOption.REPLACE_EXISTING);
        Path result = downloadDirectory.resolve(urlString.replaceAll(".*/",""));
        Files.move(tmp, result);
        return result;
    }
}
