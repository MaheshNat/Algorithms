
/**
 * Problem: Given an integer n and an set s, determine 
 * how many subsets of s add up to n
 * Solution: if s(total, i) returns the number of subsets
 * including elements at or before index i, then
 * s(total, i) = s(n - s[i], i-1) + s(n, i-1)
 */

import java.util.*;

public class SetsOfNumbersAddingToConstant {

    private static int[] set;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int lines = in.nextInt();
        set = new int[lines];
        for (int i = 0; i < lines; i++)
            set[i] = in.nextInt();
        System.out.println(rec(num, set.length - 1));
    }

    private static int rec(int total, int i) {
        if (total == 0)
            return 1;
        if (total < 0 || i < 0)
            return 0;
        if (total < set[i])
            return rec(total, i - 1);
        return rec(total - set[i], i - 1) + rec(total, i - 1);
    }
}