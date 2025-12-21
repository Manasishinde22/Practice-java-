import java.util.*;

public class TopoSort {

    public static List<Integer> findOrder(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[1]).add(e[0]);
            indegree[e[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);

            for (int next : graph.get(node)) {
                indegree[next]--;
                if (indegree[next] == 0)
                    queue.add(next);
            }
        }

        if (order.size() != n)
            return new ArrayList<>(); // cycle exists

        return order;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(findOrder(4, edges));
    }
}

// o/p: [0, 1, 2, 3]
