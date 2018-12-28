package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    private Thread threadToSpy;

    public LoggingStateThread(Thread target) {
        super(target);
        this.threadToSpy = target;
    }

    @Override
    public void run() {
        State state = null;
        State currentState;
            do {
                currentState = threadToSpy.getState();
                if (state == null | currentState!=state){
                    state = currentState;
                    System.out.println(state);
                }

            } while ((!(state == State.TERMINATED)));

        //    while (!(threadToSpy.getState()== State.TERMINATED)){
        //        System.out.println(threadToSpy.getState());
        //        Thread.sleep(20);
        //    }
        }

}
