package com.javarush.task.task22.task2201;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Строки нитей или строковые нити? Вот в чем вопрос
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new ThisUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {
        if (string==null) throwException(threadName);
        Matcher matcher = Pattern.compile("\\t(.*)\\t").matcher(string);
        if (matcher.find()){
            return matcher.group(1);
        }  else {
            throwException(threadName);
            return null;
        }
    }
    public void throwException(String threadName) {
        //String name = Thread.currentThread().getName();
        RuntimeException e;
        if (FIRST_THREAD_NAME.equals(threadName)){
            e = new TooShortStringFirstThreadException();
            //e.initCause(new StringIndexOutOfBoundsException());
            //throw e;
        }
        else if (SECOND_THREAD_NAME.equals(threadName)){
            e= new TooShortStringSecondThreadException();
        }
        else e= new RuntimeException();

        e.initCause(new StringIndexOutOfBoundsException("String index out of range: -1"));
        throw e;

    }
}
