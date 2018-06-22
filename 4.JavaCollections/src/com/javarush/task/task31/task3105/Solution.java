package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String zipName = args[1];
        String fileName = args[0];

        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipName));
        Map<String , byte[]> map = new HashMap<>();
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry())!=null){
            ByteArrayOutputStream bous = new ByteArrayOutputStream();
            copy(zipInputStream, bous);
            map.put(zipEntry.getName(), bous.toByteArray());
        }

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipName));
        String newZipName = "new" + File.separator+Paths.get(fileName).getFileName().toString();
        map.forEach((k,v)->{
            if (!k.equals(newZipName)){
                ZipEntry ze = new ZipEntry(k);
                try {
                    zipOutputStream.putNextEntry(ze);
                    zipOutputStream.write(v);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        ZipEntry entry  = new ZipEntry(newZipName);
        zipOutputStream.putNextEntry(entry);
        Files.copy(Paths.get(fileName), zipOutputStream);

        zipInputStream.close();
        zipOutputStream.close();











//        Path tmpZip = Files.createTempFile(null,null);
//        Files.move(Paths.get(zipName), tmpZip, StandardCopyOption.REPLACE_EXISTING);
//        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(tmpZip.toFile()));
//        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipName));
//
//        String newZipName = "new" + File.separator+Paths.get(fileName).getFileName().toString();
//        boolean duplicate = false;
//
//        for (ZipEntry zipEntry = zipInputStream.getNextEntry(); zipEntry!=null; zipEntry = zipInputStream.getNextEntry() ){
//            zipOutputStream.putNextEntry(zipEntry);
//            if (zipEntry.getName().equalsIgnoreCase(newZipName)){
//                Files.copy(Paths.get(fileName), zipOutputStream);
//                duplicate = true;
//                continue;
//            }
//            //zipInputStream.transferTo(zipOutputStream);
//            //zipOutputStream.write(zipInputStream.readAllBytes());
//            byte[] buffer = new byte[64000];
//            int counter;
//            while ((counter = zipInputStream.read(buffer))>0) {
//                zipOutputStream.write(buffer, 0, counter);
//            }
//        }
//
//        if (!duplicate) {
//            ZipEntry entry  = new ZipEntry(newZipName);
//            zipOutputStream.putNextEntry(entry);
//            Files.copy(Paths.get(fileName), zipOutputStream);
//        }
//
//        zipInputStream.close();
//        zipOutputStream.close();

    }
   static void copy(InputStream is, OutputStream os) throws IOException {
        byte[] buffer = new byte[64000];
        int counter;
        while ((counter = is.read(buffer))>0) {
            os.write(buffer, 0, counter);
        }
    }
}
