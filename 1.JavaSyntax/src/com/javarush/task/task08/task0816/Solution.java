package com.javarush.task.task08.task0816;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        for (int i = 0; i < 9; i++) {
            map.put("Stallone"+i, new Date());
        }
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<HashMap.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            HashMap.Entry<String, Date> pair = iterator.next();
            if (pair.getValue().getMonth()>4 && pair.getValue().getMonth()<8){
                iterator.remove();
            }
        }

    }

    public static void main(String[] args) {

    }
}
