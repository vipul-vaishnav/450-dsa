package Graphs;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{1, 2}, {3}, {3}, {}};

        Map<Integer, List<Integer>> mpp = new HashMap<>();
        for (int i = 0; i < V; i++) {
            mpp.put(i, new ArrayList<>());
            for (int node : edges[i]) {
                mpp.get(i).add(node);
            }
        }

        System.out.println(topologicalOrder(V, mpp));
        System.out.println(kahnsAlgo(V, mpp));
    }

    static List<Integer> kahnsAlgo(int V, Map<Integer, List<Integer>> adjList) {
        List<Integer> order = new ArrayList<>();
        Queue<Integer> qu = new LinkedList<>();
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int node : adjList.get(i)) {
                indegree[node]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                qu.offer(i);
            }
        }

        while (!qu.isEmpty()) {
            int curr = qu.poll();
            order.add(curr);
            for (int nbr : adjList.get(curr)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    qu.offer(nbr);
                }
            }
        }

        return order;
    }

    static List<Integer> topologicalOrder(int V, Map<Integer, List<Integer>> adjList) {
        boolean[] visited = new boolean[V];
        List<Integer> order = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited, st);
            }
        }

        while (!st.isEmpty()) {
            order.add(st.pop());
        }
        return order;
    }

    private static void dfs(int node, Map<Integer, List<Integer>> adjList, boolean[] visited, Stack<Integer> st) {
        visited[node] = true;

        for (int nbr : adjList.get(node)) {
            if (!visited[nbr]) {
                dfs(nbr, adjList, visited, st);
            }
        }

        st.push(node);
    }
}
