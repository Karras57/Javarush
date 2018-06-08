package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        load(fileInputStream);
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
       // properties.forEach(prop::setProperty);
        prop.putAll(properties);
        prop.store(outputStream,null);

//        StringBuilder sb = new StringBuilder();
//        properties.forEach((k,v)-> sb.append(k).append(" = ").append(v).append(System.lineSeparator()));
//        outputStream.write(sb.toString().getBytes());
//        outputStream.flush();
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        prop.forEach((k,v)->properties.put(k.toString(), v.toString()));

//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//        String line;
//        int separator;
//        while ((line = reader.readLine())!=null){
//            if (line.equals("#") || line.equals("!")) continue;
//            separator = line.indexOf("=");
//            if (separator == -1) separator = line.indexOf(":");
//            properties.put(line.substring(0,separator).trim(), line.substring(separator+1).trim());
//        }

    }

    public static void main(String[] args) throws Exception {
        properties.clear();
        properties.put("абыр", "hjkhj");
        properties.put("ivan", "ivanov");
        properties.put("petr", "Petrov");
        System.out.println(properties);
        File tempFile = File.createTempFile("my_temp_file",null);
        OutputStream outputStream = new FileOutputStream(tempFile);
        InputStream inputStream = new FileInputStream(tempFile);
        Solution solution = new Solution();
        solution.save(outputStream);
        properties.clear();
        solution.load(inputStream);
        System.out.println(properties);
    }
}
