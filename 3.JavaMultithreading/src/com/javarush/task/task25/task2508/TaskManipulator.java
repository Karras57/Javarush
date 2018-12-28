package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private String threadName;
    private Thread target;
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
          //  e.printStackTrace();
        }
    }

    @Override
    public void start(String threadName) {
        this.threadName = threadName;
        target = new Thread(this, threadName);
        target.start();
    }

    @Override
    public void stop() {
        target.interrupt();
    }
}
