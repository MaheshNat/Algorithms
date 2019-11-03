
/**
 * 
 */

import java.util.*;

public class Knapsack {

    private static int[] weights;
    private static int[] values;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int capacity = in.nextInt();
        int lines = in.nextInt();
        weights = new int[lines];
        values = new int[lines];
        for (int i = 0; i < lines; i++) {
            weights[i] = in.nextInt();
            values[i] = in.nextInt();
        }
        System.out.println(knapsack(lines - 1, capacity));
    }

    private static int knapsack(int item, int capacity) {
        if (item == 0 || capacity == 0)
            return 0;
        if (weights[item] > capacity)
            return knapsack(item - 1, capacity);
        return Math.max(knapsack(item - 1, capacity), values[item] + knapsack(item - 1, capacity - weights[item]));
    }
}