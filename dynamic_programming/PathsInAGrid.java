
/**
 * Problem: Given a matrix of weights, compute the shorted distance from point a to point b
 * with only using right and down movments
 * Solution: Given the following matrix of weights:
 3 7 9 2 7
 9 8 3 5 5
 1 7 9 8 5
 3 8 6 4 10
 6 3 9 7 8
 * 
 * with position (0, 0) being the start node and position (4, 4) being the end node, and f(x, y)
 * denotes the shortest weighted path, then f(x, y) = min(f(x-1, y), f(x, y-1)) + matrix[x][y]
 */

import java.util.*;

public class PathsInAGrid {

    private static int[][] matrix;
    private static int startX, startY, endX, endY;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        startX = in.nextInt();
        startY = in.nextInt();
        endX = in.nextInt();
        endY = in.nextInt();
        int rows = in.nextInt();
        int cols = in.nextInt();
        matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = in.nextInt();

        System.out.println(solution(endX, endY));
    }

    private static int solution(int x, int y) {
        if (x == startX && y == startY)
            return matrix[startX][startY];
        if (x == 0 && y == 0)
            return matrix[0][0];
        if (x == 0 && y > 0)
            return solution(x, y - 1) + matrix[x][y];
        if (y == 0 && x > 0)
            return solution(x - 1, y) + matrix[x][y];
        return Math.min(solution(x - 1, y), solution(x, y - 1)) + matrix[x][y];
    }
}