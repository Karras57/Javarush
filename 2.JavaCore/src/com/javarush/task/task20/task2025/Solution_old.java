package com.javarush.task.task20.task2025;

import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/*
Алгоритмы-числа
*/
public class Solution_old {

    public static Set<Long> treeSet = Collections.synchronizedSet(new TreeSet<>());
    public static long[][] bufferedNumbers;


    public static long[] getNumbers(long N){
        if (N<1){
            return new long[0];
        }
        bufferedNumbers = getBufferedNumbers(N);
        treeSet.clear();
        long[] result = null;
        int threadNumbers = 4;
        long part = N/threadNumbers;
        Thread[] threads = new Thread[threadNumbers];
        for (int k=0; k<threadNumbers; k++){
            Thread thread;
            if (k<threadNumbers-1) {
                thread = new findNumbers(k * part, (k + 1) * part);
            } else {
                thread = new findNumbers(k * part, N);
            }

            thread.start();
           // thread.run();

            threads[k] = thread;
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ignored) {
            }
        }


        result = new long[treeSet.size()];
        int counter=0;
        for (Long aLong : treeSet) {
            result[counter] = aLong;
            counter++;
        }

        return result;
    }

    private static int pow(int x, int n, int mod) {
        int res = 1;
        for (long p = x; n > 0; n >>= 1, p = (p * p) % mod) {
            if ((n & 1) != 0) {
                res = (int) (res * p % mod);
            }
        }
        return res;
    }

//    public static void main(String[] args) throws InterruptedException {
//
//        Date start = new Date();
//        long[] result = getNumbers(3200000000L);
//        System.out.println(new Date().getTime()-start.getTime());
//        for (long l : result) {
//            System.out.println(l);
//        }
//    }

    public static long[][] getBufferedNumbers(long max){
        int stepen = String.valueOf(max).length();
        long[][] numbers = new long[10][stepen];
        for (int i = 0; i < 10; i++) {
            long[] tmp = new long[stepen+1];
            for (int j = 0; j <stepen+1 ; j++) {
                tmp[j] = notRecursiveBinPow(i,j);
            }
            numbers[i] = tmp;
        }
        return numbers;
    }

    public static int binPow(int a, int b){
        if (b==0) return 1;
        if (b%2==1){
            return a*binPow(a,b-1);
        } else {
            int c= binPow(a,b/2);
            return c*c;
        }
    }

    public static long notRecursiveBinPow(int a, int b){
        long res = 1;
        while (b>0){
            if ((b & 1)!=0 ){
                res*=a;
                b--;

            } else {
                a*=a;
                b>>=1;
            }
        }
        return res;
    }


    public static class findNumbers extends Thread{
        private long start, end;

        public findNumbers(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            int stepen;
            long S;
            long tmp;
            mark: for (long i = start; i<end; i++){
                //первоначальная проверка - только на неувеличение разряда с конца (неуменьшение с начала)
                S = 0;
                stepen = (int)Math.log10(i)+1;
                tmp = i;
                int previous = 0, next;
                for (int j=1;j<=stepen; j++){
                    if (j==1){
                        previous = (int)tmp%10;

                    } else {
                        next = (int)tmp%10;
                        if (next>previous){
                            continue mark;
                        }
                        else {
                            previous = next;
                        }
                    }
                }

                tmp = i;
                //возводим все разряды в степень
                for (int j=1;j<=stepen; j++){
                    //S+=vozvedenieVStepen((int)(tmp%10), stepen);
                    //S+=binPow((int) tmp%10, stepen);
                    //S+=notRecursiveBinPow((int) tmp%10, stepen);
                    S+=bufferedNumbers[(int)(tmp%10)] [stepen];
                    tmp/=10;
                }
                //если другая разрядность- пропускаем
                if (((int)Math.log10(S)+1)!=stepen){
                    continue ;
                }

                //иначе проверяем уже получившееся число
                tmp = S;
                long ideal = S;
                S=0;
                //возводим все разряды в степень
                for (int j=1;j<=stepen; j++){
                    //S+=vozvedenieVStepen((int)(tmp%10), stepen);
                    //S+=binPow((int) tmp%10, stepen);
                    //S+=notRecursiveBinPow((int) tmp%10, stepen);
                    S+=bufferedNumbers[(int)(tmp%10)] [stepen];
                    tmp/=10;
                }

                if (ideal==S){
                    treeSet.add(ideal);
                }
            }
        }
    }

}
