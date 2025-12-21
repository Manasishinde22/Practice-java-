import java.util.*;

public class ReachableServer {

    public static boolean canReach(int n, int[][] edges, int start, int target) {
        // Step 1: Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
        }

        // Step 2: BFS
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == target) return true;

            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{1,3},{3,4}};
        System.out.println(canReach(5, edges, 0, 4));
    }
}

// output:true

