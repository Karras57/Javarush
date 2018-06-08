package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;// = new ArrayList<>();

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
//        System.out.printf("% 10s", "name");
//        System.exit(0);
        game = new Hippodrome(new ArrayList<>());
        Horse horse1 = new Horse("Vasya", 3,0);
        Horse horse2 = new Horse("Petya", 3,0);
        Horse horse3 = new Horse("Masha", 3,0);
        List<Horse> hippodromeHorses = game.getHorses();
        hippodromeHorses.add(horse1);
        hippodromeHorses.add(horse2);
        hippodromeHorses.add(horse3);
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run(){
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void move(){
        getHorses().forEach(Horse::move);
    }

    public void print(){
        getHorses().forEach(Horse::print);
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner(){
      return getHorses().stream().max(Comparator.comparingDouble(Horse::getDistance)).orElse(null);
    }
    public void printWinner(){
        System.out.printf("Winner is %s!", getWinner().getName());
    }

}
