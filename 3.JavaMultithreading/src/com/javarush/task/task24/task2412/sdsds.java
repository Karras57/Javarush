package com.javarush.task.task24.task2412;


class Egg {
    private Yolk y;
    public static void print(String s) {
        System.out.println(s);
    }

    protected class Yolk {
        public Yolk() {
            print("Egg.Yolk()");
        }

    }
    public Egg() {
        print("New Egg()");
        y = new Yolk(); }
}
class BigEgg extends Egg {
    public class Yolk {
        public Yolk() {
            print("BigEgg.Yolk()");
        }
    }
    public static void main(String[] args) {
        new BigEgg();
    }
}
