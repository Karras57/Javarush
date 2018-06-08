package com.javarush.task.task05.task0524;
class GenConstructor
{
    private double val;
    <T extends Number> GenConstructor(T arg)
    {
        val = arg.doubleValue();
    }

    void printValue()
    {
        System.out.println("val: "+val);
    }
}

class GenConstructorDemo
{
    public static void main(String args[])
    {
        GenConstructor gc1 = new GenConstructor(100);
        GenConstructor gc2 = new GenConstructor(123.5F);

        gc1.printValue();
        gc2.printValue();
    }
}
