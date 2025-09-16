package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public int numEnclaves(int[][] board) {
        Queue<int[]> qu = new LinkedList<>();
        int rows = board.length, cols = board[0].length;

        // Top and bottom rows
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 1) {
                qu.offer(new int[]{0, i});
                board[0][i] = 2; //safe
            }
            if (board[rows - 1][i] == 1) {
                qu.offer(new int[]{rows - 1, i});
                board[rows - 1][i] = 2;
            }
        }

        // Left and right columns
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 1) {
                qu.offer(new int[]{i, 0});
                board[i][0] = 2;
            }
            if (board[i][cols - 1] == 1) {
                qu.offer(new int[]{i, cols - 1});
                board[i][cols - 1] = 2;
            }
        }


        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!qu.isEmpty()) {
            int[] curr = qu.poll();

            for (int k = 0; k < 4; k++) {
                int nx = curr[0] + dx[k];
                int ny = curr[1] + dy[k];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && board[nx][ny] == 1) {
                    board[nx][ny] = 2;
                    qu.offer(new int[]{nx, ny});
                }
            }
        }

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    count++;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }

        return count;
    }

    public int numEnclaves2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count += dfs(i, j, m, n, grid);
                }
            }
        }
        return count;
    }

    int dfs(int x, int y, int m, int n, int[][] grid) {
        grid[x][y] = 0;

        boolean touchesBoundary = (x == 0 || x == m - 1 || y == 0 || y == n - 1);
        int area = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                int subArea = dfs(nx, ny, m, n, grid);

                if (subArea == 0) {
                    touchesBoundary = true; // propagate boundary flag
                } else {
                    area += subArea;
                }
            }
        }

        return touchesBoundary ? 0 : area;
    }
}
