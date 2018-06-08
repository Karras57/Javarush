package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String > map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Russia");
        map.put("city", "Moskow");
        System.out.println(map);
        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
//        return params.entrySet().stream().collect(StringBuilder::new, (sb,entry)->{
//            if (entry.getValue()!=null){
//                if (sb.length()!=0) sb.append( " and ");
//                sb.append(entry.getKey()).append(" = ").append("'").append(entry.getValue()).append("'");
//            }
//        }, (sb1, sb2)-> sb1.append(sb2.toString())).toString();


        StringBuilder sb = new StringBuilder();
        params.forEach((k,v)->{
                    if (v!=null){
                        if (sb.length()!=0) sb.append( " and ");
                        sb.append(k).append(" = ").append("'").append(v).append("'");
                    }
                }
        );
        return sb.toString();
    }
}
