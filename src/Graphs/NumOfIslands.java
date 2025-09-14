package Graphs;

public class NumOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, m, n, grid);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int x, int y, int m, int n, char[][] grid) {
        grid[x][y] = '0';

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1') {
                dfs(nx, ny, m, n, grid);
            }
        }
    }
}
