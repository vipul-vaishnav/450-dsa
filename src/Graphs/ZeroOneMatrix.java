package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> qu = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    visited[i][j] = true;
                    qu.offer(new int[]{i, j});
                }
            }
        }

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int lvl = 1;
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                int[] curr = qu.poll();
                int x = curr[0], y = curr[1];

                for (int d = 0; d < dir.length; d++) {
                    int nx = x + dir[d][0];
                    int ny = y + dir[d][1];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                        qu.offer(new int[]{nx, ny});
                        dist[nx][ny] = lvl;
                        visited[nx][ny] = true;
                    }
                }
            }
            lvl++;
        }

        return dist;
    }
}
