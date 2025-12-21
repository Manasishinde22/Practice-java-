import java.util.*;

public class LargestColorValue {

    public static int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }

        int[][] dp = new int[n][26];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                dp[i][colors.charAt(i) - 'a'] = 1;
            }
        }

        int visited = 0;
        int ans = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            visited++;

            for (int v : graph.get(u)) {
                for (int c = 0; c < 26; c++)
                    dp[v][c] = Math.max(dp[v][c], dp[u][c]);

                dp[v][colors.charAt(v) - 'a']++;
                indegree[v]--;

                if (indegree[v] == 0)
                    q.add(v);
            }

            for (int c = 0; c < 26; c++)
                ans = Math.max(ans, dp[u][c]);
        }

        return visited == n ? ans : -1;
    }

    // ✅ MAIN METHOD
    public static void main(String[] args) {
        int[][] edges = {
            {0,1},{0,2},{2,3},{3,4}
        };
        String colors = "abaca";

        System.out.println(largestPathValue(colors, edges)); // Expected: 3
    }
}
