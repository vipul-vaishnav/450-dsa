package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class KnightSteps {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        // Code here
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        int startX = knightPos[0], startY = knightPos[1];

        boolean[][] visited = new boolean[n + 1][n + 1];
        visited[startX][startY] = true;

        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{startX, startY, 0});

        while (!qu.isEmpty()) {
            int[] curr = qu.poll();
            int x = curr[0];
            int y = curr[1];
            int steps = curr[2];

            if (x == targetPos[0] && y == targetPos[1]) {
                return steps;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    qu.offer(new int[]{nx, ny, steps + 1});
                }
            }
        }

        return -1;
    }
}
