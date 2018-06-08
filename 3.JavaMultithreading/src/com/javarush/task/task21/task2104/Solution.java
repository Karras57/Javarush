package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Solution solution = (Solution) o;
//        return Objects.equals(first, solution.first) &&
//                Objects.equals(last, solution.last);
//    }

    public boolean equals(Object n) {

        if (n == null) return false;
        if (!(n instanceof Solution)) return false;
        if (this==n) return true;
        Solution solution  = (Solution)n;

        return (first==null ?solution.first==null:first.equals(solution.first)) && (last==null ?solution.last==null:last.equals(solution.last));
    }

    public int hashCode() {
        return 31 * (first==null ?1:first.hashCode()) + (last==null ?1:last.hashCode());
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
