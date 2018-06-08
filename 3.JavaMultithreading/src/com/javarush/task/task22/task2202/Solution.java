package com.javarush.task.task22.task2202;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {

        if (string==null) throw new TooShortStringException();
        Matcher matcher = Pattern.compile("\\s\\S*\\s\\S*\\s\\S*\\s\\S*").matcher(string);
        if (matcher.find()){
            return matcher.group().trim();
        }  else {
            throw new TooShortStringException();
        }

    }

    public static class TooShortStringException  extends RuntimeException{
    }
}
