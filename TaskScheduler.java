import java.util.*;

public class TaskScheduler {

    static boolean hasCycle(int node, List<List<Integer>> graph,
                            boolean[] visited, boolean[] inStack) {

        visited[node] = true;
        inStack[node] = true;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                if (hasCycle(next, graph, visited, inStack))
                    return true;
            } else if (inStack[next]) {
                return true;
            }
        }

        inStack[node] = false;
        return false;
    }

    public static boolean canFinish(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
        }

        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (hasCycle(i, graph, visited, inStack))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,0}};
        System.out.println(canFinish(3, edges));
    }
}
// o/p: false
