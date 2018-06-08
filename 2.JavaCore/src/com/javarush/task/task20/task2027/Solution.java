package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list = detectAllWords(crossword, "home", "same", "kovhj","fderlk", "poeejj", "d", "rr");
        //List<Word> list = detectAllWords(crossword, "d");
        list.forEach(System.out::println);

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
         int[][] wordsChar = new int[words.length][];
        for (int i = 0; i < words.length; i++) {
            char[] tmp = words[i].toCharArray();
            wordsChar[i] = new int[tmp.length];

            for (int j = 0; j <tmp.length ; j++) {
               wordsChar[i][j] = tmp[j];
            }
           // wordsChar[i] = (int[])words[i].toCharArray();
        }
        //каждое слово будем искать только по 1 разу
        int[] wordsFound = new int[words.length];
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                //пробежимся по каждому слову
                for (int k=0;k< wordsChar.length; k++  ){
                    if (crossword[i][j] == wordsChar[k][0]){
                    //    System.out.printf("первая буква совпала i= %s j= %s k= %s", i,j,k);
                        //теперь надо проверять все направления
                 //       System.out.println();
                        //на длину 1 отдельно проверим
                        if (words[k].length()==1){
                            Word word = new Word(words[k]);
                            word.setStartPoint(j,i);
                            word.setEndPoint(j,i);
                            list.add(word);
                            continue;
                        }

                        check(crossword, i, j, k, wordsChar, words, list, wordsFound);
                    }
                }
            }
        }
       // System.out.println(list);
        return list;
    }
    private static void check(int[][] crossword, int xStart, int yStart,int k, int[][] wordsChar, String [] words, List<Word> list, int[] wordsFound){
//        int deltaX=0, deltaY=0;
        checkRoute(crossword,xStart,yStart,k,wordsChar,0,1,words, list, wordsFound);
        checkRoute(crossword,xStart,yStart,k,wordsChar,1,1,words, list, wordsFound);
        checkRoute(crossword,xStart,yStart,k,wordsChar,1,0,words, list, wordsFound);
        checkRoute(crossword,xStart,yStart,k,wordsChar,1,-1,words, list, wordsFound);
        checkRoute(crossword,xStart,yStart,k,wordsChar,0,-1,words, list, wordsFound);
        checkRoute(crossword,xStart,yStart,k,wordsChar,-1,-1,words, list, wordsFound);
        checkRoute(crossword,xStart,yStart,k,wordsChar,-1,0,words, list, wordsFound);
        checkRoute(crossword,xStart,yStart,k,wordsChar,-1,1,words, list, wordsFound);


    }
    private static void checkRoute(int[][] crossword, int xStart, int yStart,int k, int[][] wordsChar, int deltaX, int deltaY, String[] words, List<Word> list, int[] wordsFound){
        if (wordsFound[k]==1) return;
        int tmpX=xStart+deltaX*(wordsChar[k].length-1);
        int tmpY=yStart+deltaY*(wordsChar[k].length-1);

        if (tmpX<0 || tmpX > crossword.length-1 ||tmpY<0 ||tmpY> crossword[xStart].length-1){
            //слово не влезет
            return ;
        }
        int xStartCopy = xStart;
        int yStartCopy = yStart;
        for (int counter = 0; counter<wordsChar[k].length; counter++,xStart+=deltaX, yStart+=deltaY) {
            if (crossword[xStart][yStart]!=wordsChar[k][counter]){
                return ;
            }
        }
        Word word = new Word(words[k]);
        word.setStartPoint(yStartCopy, xStartCopy);
        word.setEndPoint(tmpY, tmpX);
        wordsFound[k] = 1;
        list.add(word);
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
