package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
    //    List<String> addresses = new ArrayList<String>();
        //город - фамилия
        HashMap<String,String> addresses = new HashMap<>();
        while (true) {
            String town = reader.readLine();
            if (town.isEmpty()) break;
            String family = reader.readLine();

            addresses.put(town, family);
           // addresses.add(family);
        }

        //read home number
        //int houseNumber = Integer.parseInt(reader.readLine());
        String townName = reader.readLine();
        System.out.println(addresses.get(townName));

//        if (0 <= houseNumber && houseNumber < addresses.size()) {
//            String familySecondName = addresses.get(houseNumber);
//            System.out.println(familySecondName);
//        }
    }
}
