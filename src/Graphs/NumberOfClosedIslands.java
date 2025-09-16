package Graphs;

public class NumberOfClosedIslands {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int closedIslands(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

//        Queue<int[]> qu = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 0) {
//                qu.offer(new int[]{i, 0});
//                grid[i][0] = 2;
                dfs(i, 0, rows, cols, grid);
            }
            if (grid[i][cols - 1] == 0) {
//                qu.offer(new int[]{i, cols - 1});
//                grid[i][0] = 2;
                dfs(i, cols - 1, rows, cols, grid);

            }

        }

        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 0) {
//                qu.offer(new int[]{0, i});
//                grid[i][0] = 2;
                dfs(0, i, rows, cols, grid);

            }
            if (grid[rows - 1][i] == 0) {
//                qu.offer(new int[]{rows - 1, i});
//                grid[i][0] = 2;
                dfs(rows - 1, i, rows, cols, grid);

            }
        }

//        while (!qu.isEmpty()) {
//            int[] curr = qu.poll();
//
//            for (int i = 0; i < 4; i++) {
//                int nx = dx[i] + curr[0];
//                int ny = dy[i] + curr[1];
//                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 0) {
//                    grid[nx][ny] = 2;
//                    qu.offer(new int[]{nx, ny});
//                }
//            }
//        }

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) { // new closed island found
                    count++;
                    dfs(i, j, rows, cols, grid);
                }
            }
        }

        return count;
    }

    void dfs(int x, int y, int rows, int cols, int[][] grid) {
        grid[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 0) {
                dfs(nx, ny, rows, cols, grid);
            }
        }
    }
}
