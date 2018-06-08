package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd M yyyy");

        while ((line = reader.readLine())!=null){
            String stringDate = line.replaceAll("^\\D+", "");
            String name = line.replaceAll(" \\d+ \\d+ \\d+$", "");
            PEOPLE.add(new Person(name, dateFormat.parse(stringDate)));
        }
        reader.close();
        //System.out.println(PEOPLE);

    }
}
