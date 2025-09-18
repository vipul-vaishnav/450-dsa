package Matrix;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] dirs = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };


        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bfs(i, j, m, n, board, dirs);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                else if (board[i][j] == 2) board[i][j] = 1;
            }
        }
    }

    void bfs(int x, int y, int m, int n, int[][] board, int[][] dirs) {
        boolean isAlive = board[x][y] == 1;

        int liveNbrs = 0;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (board[nx][ny] == 1 || board[nx][ny] == -1) liveNbrs++;
            }
        }

        if (isAlive) {
            if (liveNbrs < 2) {
                board[x][y] = -1;
            } else if (liveNbrs > 3) {
                board[x][y] = -1;
            }
        } else {
            if (liveNbrs == 3) {
                board[x][y] = 2;
            }
        }
    }

    // Live cell + <2 neighbors → dies (lonely).

    // Live cell + 2 or 3 neighbors → survives.

    // Live cell + >3 neighbors → dies (overcrowded).

    // Dead cell + exactly 3 neighbors → becomes alive (birth).

    // Neighbors = the 8 surrounding cells (diagonal counts too).

    // If a live cell (1) will die, mark it something like -1 (means was alive, now dead).

    // If a dead cell (0) will come alive, mark it something like 2 (means was dead, now alive).
}
