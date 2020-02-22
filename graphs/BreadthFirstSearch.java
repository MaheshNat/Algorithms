import java.util.*;
import java.io.*;

/**
 * Breath First Search (BFS) is a graph traversal method going across the breath
 * across the graph instead of going deep, staying as close to the vertex as
 * possible and expanding outwards.
 */

public class BreadthFirstSearch {
    public static void main(String[] args) {
        ArrayList<Integer>[] adjacencyList = (ArrayList<Integer>[]) new ArrayList[10];
        boolean[] visited = new boolean[10];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int neighbor : adjacencyList[current])
                if (!visited[neighbor]) {
                    q.add(neighbor);
                    visited[neighbor] = true;
                }
        }
    }
}