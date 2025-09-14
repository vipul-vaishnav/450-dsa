package Graphs;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int largestArea = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) largestArea = Math.max(largestArea, dfs(i, j, m, n, grid));
            }
        }
        return largestArea;
    }

    int dfs(int x, int y, int m, int n, int[][] grid) {
        grid[x][y] = 0;
        int area = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                area += dfs(nx, ny, m, n, grid);
            }
        }

        return area;
    }
}
