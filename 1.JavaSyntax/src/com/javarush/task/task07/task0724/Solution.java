package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human ded1 = new Human("Ded1", true,90);
        Human ded2 = new Human("Ded2", true,90);
        Human babka1 = new Human("Babka1", false,90);
        Human babka2 = new Human("Babka2", false,90);
        Human otec = new Human("Otec", true,40, ded1, babka1);
        Human mat = new Human("Mat", false,40, ded2, babka2);
        Human sin = new Human("Sin",true,18, otec, mat);
        Human sin1 = new Human("Sin1",true,18, otec, mat);
        Human sin2 = new Human("Sin2",true,18, otec, mat);
        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(babka1);
        System.out.println(babka2);
        System.out.println(otec);
        System.out.println(mat);
        System.out.println(sin);
        System.out.println(sin1);
        System.out.println(sin2);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;


        public Human(String name, boolean sex, int age){
            this(name, sex, age, null, null);
        }
        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















