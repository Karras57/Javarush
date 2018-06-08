package com.javarush.task.task06.task0613;

/* 
Кот и статика
*/

public class Solution {
    public static void main(String[] args) {
        Cat[] catDom = new Cat[10];
        for (Cat cat: catDom){
            cat = new Cat();
        }
        System.out.println(Cat.catCount);
    }

    public static class Cat {
        public static int catCount = 0;

        public Cat(){
            catCount++;
        }
    }
}
