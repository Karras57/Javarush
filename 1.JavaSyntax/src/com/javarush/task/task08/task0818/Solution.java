package com.javarush.task.task08.task0818;

import java.util.*;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            map.put("Фамилия "+i, rnd.nextInt(1000));
        }
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator<HashMap.Entry<String, Integer>> iterator = map.entrySet().iterator();


        while (iterator.hasNext()){
            HashMap.Entry<String, Integer> pair = iterator.next();
            if (pair.getValue()<500){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}