package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);

        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] result = new byte[ip.length];
        if (ip.length!=mask.length){
        return result;
        }

        for (int i = 0; i < ip.length; i++) {
            result[i] = (byte)(ip[i] & mask[i]);
        }
        return result;
    }

    public static void print(byte[] bytes) {
        for (byte aByte : bytes) {
            int[] buf = new int[8];
            int tmp = aByte&255;
            for (int i = 0; i < 8; i++) {
                buf[8-1-i] =  (tmp%2);
                tmp/=2;
            }
            for (int b : buf) {
                System.out.print(b);
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}
