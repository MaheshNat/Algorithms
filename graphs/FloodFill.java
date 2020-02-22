import java.util.*;

public class FloodFill {
    public static void main(String[] args) {
        int[][] arr = new int[][] { { 0, 0, 1, 0, 1, 1 }, { 0, 1, 1, 0, 1, 1 }, { 0, 1, 1, 0, 1, 0 },
                { 1, 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0, 1 }, { 0, 0, 1, 1, 0, 1 }, };

        System.out.println(rec(arr, 1, 1, 0));
    }

    private static int rec(int[][] arr, int row, int col, int total) {
        if (arr[row][col] == 0)
            return 0;
        total++;
        if (row > 0)
            return total + rec(arr, row - 1, col, total);
        if (row < arr.length - 1)
            return total + rec(arr, row + 1, col, total);
        if (col > 0)
            return total + rec(arr, row, col - 1, total);
        if (col < arr[0].length - 1)
            return total + rec(arr, row, col + 1, total);
        return total;
    }
}