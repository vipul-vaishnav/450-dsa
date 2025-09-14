package Graphs;

import java.util.ArrayList;

public class RatInAMaze {
    // Function to find all possible paths
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        // DFS + backtracking

        ArrayList<String> paths = new ArrayList<>();

        int n = maze.length;

        dfs(0, 0, n, maze, paths, new StringBuilder());

        return paths;
    }

    void dfs(int sx, int sy, int n, int[][] maze, ArrayList<String> paths, StringBuilder currPath) {
        maze[sx][sy] = 0;

        if (sx == n - 1 && sy == n - 1) {
            paths.add(currPath.toString());
        } else {
            // int[][] dn = {
            //     {-1, 0}, // up
            //     {1, 0},  // down
            //     {0, 1},  // right
            //     {0, -1}  // left
            // };

            // char[] dc = {'U', 'D', 'R', 'L'};

            char[] dc = {'D', 'L', 'R', 'U'};
            int[][] dn = {
                    {1, 0},   // D
                    {0, -1},  // L
                    {0, 1},   // R
                    {-1, 0}   // U
            }; // this will give in lexicographically smallest order

            for (int i = 0; i < 4; i++) {
                int nx = sx + dn[i][0];
                int ny = sy + dn[i][1];
                char move = dc[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && maze[nx][ny] == 1) {
                    currPath.append(move);
                    dfs(nx, ny, n, maze, paths, currPath);
                    currPath.deleteCharAt(currPath.length() - 1);
                }
            }
        }

        maze[sx][sy] = 1;
    }
}
