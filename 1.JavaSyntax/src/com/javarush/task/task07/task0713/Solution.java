package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> listOther = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            boolean flag = true;
            if (x%2 ==0 ){
                list2.add(x);
                flag = false;
            }
            if (x%3 ==0 ){
                list3.add(x);
                flag = false;
            }
            if (flag){
                listOther.add(x);
            }
        }
        printList(list3);
        printList(list2);
        printList(listOther);
    }

    public static void printList(List<Integer> list) {
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
