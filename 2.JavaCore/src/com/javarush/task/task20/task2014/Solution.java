package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        System.out.println(new Solution(4));

        try{
            File file = File.createTempFile("my_temple_file", null);
            InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = new FileOutputStream(file);
            Solution savedObject = new Solution(22);
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(savedObject);
            oos.flush();
            Thread.sleep(1000);
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Solution loadedObject = (Solution) ois.readObject();
            System.out.println(savedObject.string.equals(loadedObject.string));
        }
        catch (FileNotFoundException ignored){}
        catch (IOException ignored){}
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }





}
