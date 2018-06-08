package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String dedName = reader.readLine();
        Cat catDed = new Cat(dedName);

        String babkaName = reader.readLine();
        Cat catBabka = new Cat(babkaName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, null, catDed);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, catBabka, null);

        String sinName = reader.readLine();
        Cat catSin = new Cat(sinName, catMother, catFather);

        String dochName = reader.readLine();
        Cat catDoch = new Cat(dochName, catMother, catFather);

        System.out.println(catDed);
        System.out.println(catBabka);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSin);
        System.out.println(catDoch);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother) {
            this.name = name;
            this.mother = mother;
        }
        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString() {
            String description = "";
            if (mother == null)
                description =  "Cat name is " + name + ", no mother";
            else
                description =  "Cat name is " + name + ", mother is " + mother.name;
            if (father == null){
                description+= ", no father";
            }
            else{
                description+= ", father is "+ father.name;
            }
            return description;
        }
    }

}
