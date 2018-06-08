package com.javarush.task.task15.task1527;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String s ="qwer \"ty\" \"ui\" op";
        System.out.println(s);
        String pattern = ".*y";
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher m  = pattern1.matcher(s);
        if (m.find()){
            System.out.println(m.group());
        }
    }
}
