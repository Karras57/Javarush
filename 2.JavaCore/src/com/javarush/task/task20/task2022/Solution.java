package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
       // out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        //FileDescriptor descriptor = (FileDescriptor) in.readObject();
        stream = new FileOutputStream(fileName, true);
      //  in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution("d:\\1C\\20180422\\1.txt");
        solution.writeObject("testTEST");
        File tmp = File.createTempFile("template", null);
        OutputStream outputStream = new FileOutputStream(tmp);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);

        oos.writeObject(solution);
       // solution.writeObject(oos);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tmp));
        Solution solution1 = (Solution) ois.readObject();
        solution1.writeObject("newtest");

    }
}
