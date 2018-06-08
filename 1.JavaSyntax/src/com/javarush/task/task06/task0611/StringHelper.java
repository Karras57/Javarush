package com.javarush.task.task06.task0611;

/* 
Класс StringHelper
*/

public class StringHelper {
    public static String multiply(String s) {
      //  String result = "";
        //напишите тут ваш код
      //  return result;
        return multiply(s,5);
    }

    public static String multiply(String s, int count) {
        StringBuffer stringBuffer = new StringBuffer();
      //  String result = "";
        for (int i = 0; i < count; i++) {
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {

    }
}
