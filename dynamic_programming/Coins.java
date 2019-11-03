
/**
 * Problem: given a set of coins and a number n, compute the minimum number of coins which add up to n
 * Solution: If a set of coins was {1, 3, 4} for example, and n=10, and c(n) returns the minimum amount of coins which
 * add up to n, then c(n) = min(c(n-1), c(n-3), or c(n-4)) + 1. Also, to avoid repeating calculations, already computed
 * solutions are stored in an array (memoization)
 */

import java.util.*;

public class Coins {

    private static int[] coins;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lines = in.nextInt();
        coins = new int[lines];
        for (int i = 0; i < lines; i++)
            coins[i] = in.nextInt();
        int n = in.nextInt();
        System.out.println(solution(n, new int[n]));
    }

    public static int solution(int n, int[] solutions) {
        for (int coin : coins)
            if (n - coin <= 0)
                return 1;
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (solutions[n - coin] != 0)
                min = Math.min(min, solutions[n - coin]);
            else {
                int solution = solution(n - coin, solutions);
                min = Math.min(min, solution);
                solutions[n - coin] = solution;
            }
        }
        return min + 1;
    }
}