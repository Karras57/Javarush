package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
//        clock.start();
        Thread.sleep(3500);
        clock.interrupt();
       // if (clock.isAlive()) clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            try {
                while (countSeconds>0){
                    System.out.print(countSeconds+" ");
                    Thread.sleep(1000);
                    countSeconds--;
                }
                System.out.print("Марш!");
            }
            catch (InterruptedException ex){
                System.out.println("Прервано!");
            }
            //add your code here - добавь код тут
        }
    }
}
