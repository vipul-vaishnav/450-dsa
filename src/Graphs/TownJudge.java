package Graphs;

public class TownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] outdegree = new int[n + 1];
        int[] indegree = new int[n + 1];

        for (int[] relation : trust) {
            outdegree[relation[0]]++;
            indegree[relation[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (outdegree[i] == 0 && indegree[i] == n - 1) return i;
        }

        return -1;
    }
}
