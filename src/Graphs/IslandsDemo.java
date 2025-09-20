package Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IslandsDemo {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Map<Integer, Integer> areaOfIslands = new HashMap<>();

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 1, 1},
                {0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0},
        };

        System.out.println(numberOfIslands(grid));
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(areaOfIslands);
        System.out.println(Arrays.toString(minMaxAreas()));
    }

    private static int[] minMaxAreas() {
        if (areaOfIslands.isEmpty()) return new int[]{0, 0};
        int[] res = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        for (Map.Entry<Integer, Integer> e : areaOfIslands.entrySet()) {
            int area = e.getValue();
            res[0] = Math.min(res[0], area);
            res[1] = Math.max(res[1], area);
        }
        return res;
    }

    private static int numberOfIslands(int[][] grid) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    dfs(i, j, m, n, grid, count, visited);
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, int m, int n, int[][] grid, int color, boolean[][] visited) {
        visited[i][j] = true;
        grid[i][j] = color;
        areaOfIslands.put(color, areaOfIslands.getOrDefault(color, 0) + 1);

        for (int d = 0; d < 4; d++) {
            int xx = i + dx[d];
            int yy = j + dy[d];

            if (xx >= 0 && xx < m && yy >= 0 && yy < n && !visited[xx][yy] && grid[xx][yy] == 1) {
                dfs(xx, yy, m, n, grid, color, visited);
            }
        }
    }
}
