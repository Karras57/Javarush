package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];
        List<InputStream> list = Arrays.stream(args)
                .skip(1)
                .sorted()
                .map(x-> {
            try {
                return Files.newInputStream(Paths.get(x));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());

        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(list));
        ZipInputStream zis = new ZipInputStream(sequenceInputStream);
        ZipEntry zipEntry = zis.getNextEntry();
        if (zipEntry!=null){
            // OutputStream os = Files.newOutputStream(Paths.get(resultFileName));
            OutputStream os = new FileOutputStream(resultFileName);
            copy(zis, os);
            os.close();
        }
        zis.close();
        sequenceInputStream.close();

//        Path archive = Files.createTempFile("archive", null);
//        OutputStream streamWriter = Files.newOutputStream(archive);
//        for (int i = 1; i < args.length; i++) {
//            try (InputStream inputStream = Files.newInputStream(Paths.get(args[i]))){
//                copy(inputStream, streamWriter);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        ZipInputStream zis = new ZipInputStream(Files.newInputStream(archive));
//        ZipEntry zipEntry = zis.getNextEntry();
//        if (zipEntry!=null){
//            OutputStream os = Files.newOutputStream(Paths.get(resultFileName));
//            copy(zis, os);
//            os.close();
//           // Files.copy(zis, Paths.get(resultFileName));
//        }
//        zis.close();
    }


    static void copy(InputStream is, OutputStream os) throws IOException {
        byte[] buffer = new byte[64000];
        int counter;
        while ((counter = is.read(buffer))>0) {
            os.write(buffer, 0, counter);
        }
    }
}
