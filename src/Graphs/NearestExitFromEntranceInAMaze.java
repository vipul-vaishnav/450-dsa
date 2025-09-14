package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInAMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        // gonna go with bfs makr visited as + get steps coutn in an int[] qu elemtne 01 are coords and 2 is curr steps if x and y are at edege that means its an exit
        // that means either a row or col i s 0 or m-1 or n - 1 then its an exit then we can return curr[2] if after while loop if we dont return we return -1;

        int m = maze.length, n = maze[0].length;
        Queue<int[]> qu = new LinkedList<>();
        int x = entrance[0], y = entrance[1];
        qu.offer(new int[]{x, y, 0}); //x,y,stepCount
        maze[x][y] = '+';

        int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!qu.isEmpty()) {
            int[] curr = qu.poll();
            int sx = curr[0], sy = curr[1], steps = curr[2];
            if (!(sx == x && sy == y)) {
                if (sx == 0 || sx == m - 1 || sy == 0 || sy == n - 1) {
                    return steps;
                }
            }

            for (int[] ints : d) {
                int nx = sx + ints[0];
                int ny = sy + ints[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == '.') {
                    qu.offer(new int[]{nx, ny, steps + 1});
                    maze[nx][ny] = '+';
                }
            }
        }

        return -1;
    }
}
