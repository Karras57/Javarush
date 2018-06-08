package com.javarush.task.task08.task0815;

import java.util.*;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map =new HashMap<>();
        for (int i = 0; i < 10; i++) {
           map.put("Фамилия"+i, "Имя"+i );
        }
        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        Collection list  = map.values();
        list.removeIf(x-> !x.equals(name));
        return list.size();

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        return map.containsKey(lastName)? 1:0;

    }

    public static void main(String[] args) {

    }
}
