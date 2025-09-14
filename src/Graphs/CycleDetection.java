package Graphs;

import java.util.*;

public class CycleDetection {
    public static void main(String[] args) {
        int[][] udg = {{1, 2}, {0, 3}, {0, 4}, {0, 5}, {0, 5}, {3, 4}};
        int[][] udg2 = {{1, 2}, {0, 3}, {0, 4}, {1}, {2}};

        System.out.println(detectCycleInUDGusingDFS(udg));
        System.out.println(detectCycleInUDGusingDFS(udg2));

        System.out.println(bfsCycleCheck(udg));
        System.out.println(bfsCycleCheck(udg2));
    }

    public static Map<Integer, List<Integer>> getAdjList(int[][] graph) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            adjList.put(i, new ArrayList<>());
            for (int node : graph[i]) {
                adjList.get(i).add(node);
            }
        }
        return adjList;
    }

    public static boolean bfsCycleCheck(int[][] g) {
        Map<Integer, List<Integer>> adjList = getAdjList(g);
        boolean[] visited = new boolean[g.length];

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                boolean res = bfsHelper(i, -1, visited, adjList);
                if (res) return true;
            }
        }

        return false;
    }

    static boolean bfsHelper(int i, int parent, boolean[] visited, Map<Integer, List<Integer>> adjList) {
        Queue<int[]> qu = new LinkedList<>();

        qu.offer(new int[]{i, parent});
        visited[i] = true;

        while (!qu.isEmpty()) {
            int[] curr = qu.poll();
            int node = curr[0], nodeParent = curr[1];
            List<Integer> nbrs = adjList.get(node);
            for (int nbr : nbrs) {
                if (!visited[nbr]) {
                    qu.offer(new int[]{nbr, node});
                    visited[nbr] = true;
                } else {
                    if (nbr != nodeParent) return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycleInUDGusingDFS(int[][] g) {
        int V = g.length;
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                boolean res = dfs(i, -1, visited, g);
                if (res) return true;
            }
        }

        return false;
    }

    private static boolean dfs(int i, int parent, boolean[] visited, int[][] g) {
        visited[i] = true;

        int[] nbrs = g[i];

        for (int nbr : nbrs) {
            if (!visited[nbr]) {
                boolean res = dfs(nbr, i, visited, g);
                if (res) return true;
            } else {
                if (nbr != parent) return true;
            }
        }

        return false;
    }
}
