import java.util.*;

public class HighValueUsers {

    public static List<Integer> findUsers(int[][] orders) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] o : orders) {
            map.put(o[0], map.getOrDefault(o[0], 0) + o[1]);
        }

        List<Integer> result = new ArrayList<>();
        for (int user : map.keySet()) {
            if (map.get(user) > 1000)
                result.add(user);
        }
        return result;
    }

    // ✅ MAIN METHOD FOR TESTING
    public static void main(String[] args) {
        int[][] orders = {
            {1, 400},
            {2, 700},
            {1, 700},
            {3, 200}
        };

        System.out.println(findUsers(orders)); // Expected: [1]
    }
}

// o/p: [1]
