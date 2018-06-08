package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int a = 0;
        a = (strength > anotherCat.strength) ? ++a : --a;
        a = (age > anotherCat.age) ? ++a : --a;
        a = (weight > anotherCat.weight) ? ++a : --a;
        return a>0;
    }

    public static void main(String[] args) {

    }
}
