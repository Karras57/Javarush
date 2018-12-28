package com.javarush.task.task25.task2505;

/* 
Без дураков
*/
public class Solution {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
        //Thread.sleep(2000);
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
           // setDaemon(true);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }

        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler{
            public MyUncaughtExceptionHandler() {
            }

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.sleep(500);
                   // System.out.printf("%s, %s, %s", secretKey, t.getName(), e.getMessage());
                    System.out.println(String.format("%s, %s, %s", secretKey, t.getName(), e.getMessage()));
                } catch (InterruptedException e1) {
                  //  e1.printStackTrace();
                }
            }
        }
    }

}

