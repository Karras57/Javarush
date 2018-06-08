package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException{
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(staticString);
        }
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            staticString = (String)objectInputStream.readObject();
        }
    }

    public static void main(String[] args) {


    }
}
