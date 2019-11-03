
/**
 * Problem: Given a matrix of 0s and 1s, find the area of the largest
 * square of 1s in the matrix
 * Solution: if f(x, y) returns the largest square which can be made, 
 * then f(x, y) = min(f(x+1, y), f(x, y+1), f(x+1, y+1))
 */

import java.util.*;

public class LargestSquare {

    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = in.nextInt();

        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int tempMaxArea = largestSquare(i, j);
                if (tempMaxArea > maxArea)
                    maxArea = tempMaxArea;
            }
        }
        System.out.println(Math.pow(maxArea, 2));
    }

    private static int largestSquare(int i, int j) {
        if (matrix[i][j] == 0)
            return 0;
        if (i == matrix.length - 1 && j == matrix[i].length - 1)
            return 1;
        if (i == matrix.length - 1)
            return largestSquare(i, j + 1) + 1;
        if (j == matrix[i].length - 1)
            return largestSquare(i + 1, j) + 1;
        return Math.min(Math.min(largestSquare(i + 1, j), largestSquare(i, j + 1)), largestSquare(i + 1, j + 1)) + 1;

    }
}