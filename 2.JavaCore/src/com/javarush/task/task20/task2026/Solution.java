package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        //искать с левого верхнего угла
        Integer counter = 0;
        if (a.length==0) return counter;
        byte[][] copy = new byte[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j]==1 && copy[i][j]==0){
                    counter++;
                    findReactangle(i,j,a, copy);
                }
            }
        }
        return counter;
    }
    private static void findReactangle(int xStart, int yStart, byte[][] a,  byte[][] copy){
       // if (copy[xStart][yStart]==1) return; //уже включен куда-то
        for (int i = xStart; i < a.length; i++) {
            if (a[i][yStart]==0) break;
            for (int j = yStart; j < a[i].length; j++) {
                if (a[i][j]==1){
                    copy[i][j] = 1;
                } else break;
            }
        }

    }
}
