package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] twoSolutions = new Solution[2];
        for (int i = 0; i < twoSolutions.length; i++) {
            Solution twoSolution = new Solution();
            twoSolution.innerClasses[0] = twoSolution.new InnerClass();
            twoSolution.innerClasses[1] = twoSolution.new InnerClass();
            twoSolutions[i] = twoSolution;
        }
        return twoSolutions;
    }

    public static void main(String[] args) {

    }
}
