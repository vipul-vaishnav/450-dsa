package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        Queue<int[]> coords = new LinkedList<>();

        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, n, grid, coords, visited);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        while (!coords.isEmpty()) {
            int[] curr = coords.poll();
            int x = curr[0], y = curr[1], dist = curr[2];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    if (grid[nx][ny] == 1) return dist;
                    else if (grid[nx][ny] == 0) {
                        coords.offer(new int[]{nx, ny, dist + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return -1;
    }

    void dfs(int i, int j, int n, int[][] grid, Queue<int[]> coords, boolean[][] visited) {
        visited[i][j] = true; // marking first island visited;
        coords.offer(new int[]{i, j, 0});

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny, n, grid, coords, visited);
            }
        }
    }
}
