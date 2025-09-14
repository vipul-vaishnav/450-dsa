package Graphs;

import java.util.*;

public class GraphEngine {
    int V;
    List<List<Integer>> edges;

    GraphEngine(int _V) {
        this.V = _V;
        this.edges = new ArrayList<>();
    }

    public static void main(String[] args) {
        var g = new GraphEngine(6);

        g.addEdge(0, 1, true);
        g.addEdge(0, 2, true);
        g.addEdge(2, 3, true);
        g.addEdge(2, 4, true);
        g.addEdge(3, 4, true);
        g.addEdge(4, 5, true);
        g.addEdge(4, 0, true);

//        g.printGraph();
        System.out.println(g.dfs(0));
        System.out.println(g.bfs());
    }

    void addEdge(int source, int destination, boolean isUndirected) {
        List<Integer> edge = new ArrayList<>();
        edge.add(source);
        edge.add(destination);

        this.edges.add(edge);

        if (isUndirected) {
            List<Integer> edge2 = new ArrayList<>();
            edge2.add(destination);
            edge2.add(source);
            this.edges.add(edge2);
        }
    }

    Map<Integer, List<Integer>> getAdjList() {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < this.V; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (List<Integer> edge : this.edges) {
            int from = edge.get(0), to = edge.get(1);
            adjList.get(from).add(to);
        }
        return adjList;
    }

    void printGraph() {
        Map<Integer, List<Integer>> adjList = getAdjList();
        for (int i = 0; i < this.V; i++) {
            System.out.println(i + ": " + adjList.get(i));
        }
    }

    List<Integer> dfs(int source) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[this.V];
        Map<Integer, List<Integer>> adjList = getAdjList();

        for (int i = 0; i < this.V; i++) {
            if (!visited[source]) {
                dfsHelper(source, adjList, visited, list);
            }
        }

        return list;
    }

    private void dfsHelper(int node, Map<Integer, List<Integer>> adjList, boolean[] visited, List<Integer> list) {
        visited[node] = true;
        list.add(node);

        List<Integer> nbrs = adjList.get(node);

        for (int nbr : nbrs) {
            if (!visited[nbr]) dfsHelper(nbr, adjList, visited, list);
        }
    }

    List<Integer> bfs() {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> adjList = getAdjList();

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfsOfGraph(i, adjList, visited, res);
            }
        }
        return res;
    }

    private void bfsOfGraph(int i, Map<Integer, List<Integer>> adjList, boolean[] visited, List<Integer> res) {
        Queue<Integer> qu = new LinkedList<>();

        visited[i] = true;
        qu.offer(i);

        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int k = 0; k < size; k++) {
                int curr = qu.poll();
                res.add(curr);
                for (int nbr : adjList.get(curr)) {
                    if (!visited[nbr]) {
                        visited[nbr] = true;
                        qu.offer(nbr);
                    }
                }
            }
        }
    }
}
