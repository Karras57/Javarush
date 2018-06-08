package com.javarush.task.task08.task0827;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Calendar calendar = new GregorianCalendar();
        //Date lDate = new Date(date);
        calendar.setTime(new Date(date));
        return   calendar.get(Calendar.DAY_OF_YEAR)%2 ==1;
       // return true;
    }
}
