package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map =new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("Фамилия"+i, "Имя"+i );
        }
        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        Collection<String> values= map.values();
        ArrayList<String> toDelete = new ArrayList<>();
        for(String s: values){
           if (Collections.frequency(values, s)>1){
              // removeItemFromMapByValue(map, s);
               toDelete.add(s);
           }
        }
        for (String s : toDelete) {
            removeItemFromMapByValue(map, s);
        }

      // toDelete.forEach(x->removeItemFromMapByValue(map, x));

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
