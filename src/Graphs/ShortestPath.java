package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // 8 directions: up, down, left, right, and 4 diagonals
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int n = grid.length;

        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;

        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{0, 0});
        grid[0][0] = 1;

        int path = 1;

        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                int[] curr = qu.poll();
                if (curr[0] == n - 1 && curr[1] == n - 1) {
                    return path;
                }

                for (int d = 0; d < 8; d++) {
                    int nx = curr[0] + dx[d];
                    int ny = curr[1] + dy[d];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 0) {
                        qu.offer(new int[]{nx, ny});
                        grid[nx][ny] = 1;
                    }
                }
            }

            path++;
        }

        return -1;
    }
}
