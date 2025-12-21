import java.util.*;

public class LongestPathDAG {

    public static int longestPath(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[0] = 0;

        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q.add(i);

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int w = edge[1];

                if (dist[u] != Integer.MIN_VALUE)
                    dist[v] = Math.max(dist[v], dist[u] + w);

                indegree[v]--;
                if (indegree[v] == 0)
                    q.add(v);
            }
        }

        return dist[n - 1] == Integer.MIN_VALUE ? -1 : dist[n - 1];
    }

    public static void main(String[] args) {
        int[][] edges = {
            {0,1,2},{0,2,4},{1,2,1},
            {1,3,7},{2,4,3},{3,4,1}
        };
        System.out.println(longestPath(5, edges));
    }
}

// o/p: 10
