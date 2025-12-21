import java.util.*;

public class MaxAPICaller {

    public static int maxUser(int[][] logs) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] log : logs) {
            map.put(log[0], map.getOrDefault(log[0], 0) + 1);
        }

        int user = -1, max = 0;

        for (int u : map.keySet()) {
            if (map.get(u) > max) {
                max = map.get(u);
                user = u;
            }
        }
        return user;
    }

    public static void main(String[] args) {
        int[][] logs = {{1,0},{2,0},{1,0},{1,0},{2,0}};
        System.out.println(maxUser(logs));
    }
}
// o/p: 1
