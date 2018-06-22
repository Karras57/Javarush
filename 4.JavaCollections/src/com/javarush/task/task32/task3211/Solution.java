package com.javarush.task.task32.task3211;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.util.Arrays;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
       // md.update(byteArrayOutputStream.toByteArray());
//        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
//        String test = (String ) ois.readObject();
       // md.update(test.getBytes());
        md.update(byteArrayOutputStream.toByteArray());
        StringBuilder sb = new StringBuilder();
        byte[] buffer = md.digest();
        for (int i = 0; i < buffer.length; i++) {
            String s = Integer.toHexString(0xff & buffer[i]);
            s = (s.length() == 1) ? "0" + s : s;
            sb.append(s);
        }

        return sb.toString().equals(md5);
    }
}
