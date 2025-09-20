package Graphs;

import java.util.*;

public class PrimsDemo {
    public static void main(String[] args) {
        Graph g = getGraph();

        System.out.println("Graph built with " + g.V + " vertices.");
        for (int i = 0; i < g.V; i++) {
            List<Edge> list = g.adj.get(i);
            System.out.print(i + ": ");
            for (Edge e : list) {
                System.out.print("(" + e.to + ", " + e.weight + "), ");
            }
            System.out.println();
        }

        System.out.println(mstUsingPrims(g));
    }

    private static Graph getGraph() {
        Graph g = new Graph(10);

        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(0, 9, 15);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 8, 11);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 6);
        g.addEdge(5, 9, 12);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 9);
        g.addEdge(7, 8, 2);
        g.addEdge(8, 9, 7);
        return g;
    }

    static long mstUsingPrims2(Graph g) {
        long sum = 0L;
        boolean[] inMst = new boolean[g.V];
        int[] parentArr = new int[g.V];
        Arrays.fill(parentArr, -1);
        List<int[]> mstEdges = new ArrayList<>(); // {parent, node, weight}

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // [weight, node, parent]

        // handle disconnected graphs by starting Prim from every unvisited node
        for (int start = 0; start < g.V; start++) {
            if (inMst[start]) continue;
            pq.offer(new int[]{0, start, -1});

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int weight = curr[0], node = curr[1], parent = curr[2];

                if (inMst[node]) continue;

                inMst[node] = true;
                parentArr[node] = parent;
                if (parent != -1) {
                    mstEdges.add(new int[]{parent, node, weight});
                    sum += weight;
                }

                for (Edge e : g.adj.get(node)) {
                    if (!inMst[e.to]) {
                        pq.offer(new int[]{e.weight, e.to, node});
                    }
                }
            }
        }

        System.out.println("parent array: " + Arrays.toString(parentArr));
        System.out.println("MST edges:");
        for (int[] e : mstEdges) {
            System.out.printf("%d - %d : %d\n", e[0], e[1], e[2]);
        }

        return sum;
    }

    static int mstUsingPrims(Graph g) {
        int sum = 0;
        int[] inMst = new int[g.V];
        int[] parentArr = new int[g.V];
        Arrays.fill(parentArr, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, -1}); // [weight, node, parent]

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int weight = curr[0], node = curr[1], parent = curr[2];

            if (inMst[node] == 0) {
                parentArr[node] = parent;
                inMst[node] = 1;
                sum += weight;
            } else {
                continue;
            }

            List<Edge> li = g.adj.get(node);
            for (Edge e : li) {
                int[] queueEntry = new int[]{e.weight, e.to, node};
                pq.offer(queueEntry);
            }
        }

        System.out.println(Arrays.toString(parentArr));

        return sum;
    }

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Graph {
        int V;
        Map<Integer, List<Edge>> adj;

        Graph(int V) {
            this.V = V;
            adj = new HashMap<>();
            for (int i = 0; i < V; i++) {
                adj.put(i, new ArrayList<>());
            }
        }

        void addEdge(int u, int v, int w) {
            adj.get(u).add(new Edge(v, w));
            adj.get(v).add(new Edge(u, w)); // undirected
        }
    }
}
