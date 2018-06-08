package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man = new Man("Vasya", 5, "dervnya");
        Man man1 = new Man("Vasya", 5, "dervnya");
        Woman woman = new Woman("Masha", 4, "derevnya");
        Woman woman1 = new Woman("Masha", 4, "derevnya");
        System.out.println(man.name + " "+ man.age +" "+ man.address);
        System.out.println(man1.name + " "+ man1.age +" "+ man1.address);
        System.out.println(woman.name + " "+ woman.age +" "+ woman.address);
        System.out.println(woman1.name + " "+ woman1.age +" "+ woman1.address);
    }


   public static class Man {
       String name;
       int age;
       String address;

       Man(String name, int age, String address) {
           this.name = name;
           this.age = age;
           this.address = address;
       }
   }
        public static class Woman {
            String name;
            int age;
            String address;
            Woman(String name, int age, String address) {
                this.name = name;
                this.age = age;
                this.address = address;
            }
        }

   }

