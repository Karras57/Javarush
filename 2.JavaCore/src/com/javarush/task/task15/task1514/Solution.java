package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(1.0, "hjh");
        labels.put(2.0, "hhjh");
        labels.put(3.0, "h5456hjh");
        labels.put(4.0, "hsdsfhjh");
        labels.put(5.0, "hhjh546544");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
