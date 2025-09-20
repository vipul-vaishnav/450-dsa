package Graphs;

public class BipartiteCheck {
    public static void main(String[] args) {
        int[][] graph1 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        int[][] graph2 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};

        System.out.println(isBipartite(graph1));
        System.out.println(isBipartite(graph2));
    }

    public static boolean isBipartite(int[][] graph) {
        int color = 1;
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                boolean res = dfs(i, graph, visited, color);
                if (!res) return false;
            }
        }
        return true;
    }

    static boolean dfs(int node, int[][] graph, int[] visited, int color) {
        visited[node] = color;

        int[] nbrs = graph[node];
        for (int nbr : nbrs) {
            if (visited[nbr] == 0) {
                boolean res = dfs(nbr, graph, visited, 3 - color);
                if (!res) return false;
            } else {
                if (visited[nbr] == visited[node]) return false;
            }
        }

        return true;
    }
}
