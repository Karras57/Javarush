package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

import java.lang.reflect.Field;

public class Solution {
    public int intVar;
    public double doubleVar;
    public Double DoubleVar;
    public boolean booleanVar;
    public Object ObjectVar;
    public Exception ExceptionVar;
    public String StringVar;
    public static void main(String[] args) throws IllegalAccessException {
        Field[] fields = Solution.class.getDeclaredFields();
        Solution solution = new Solution();
        for (Field field : fields) {
           // field.setAccessible(true);
          //  System.out.println(field);
          //  System.out.println(field.getType());
            System.out.println(field.get(solution));
        }
    }
}
