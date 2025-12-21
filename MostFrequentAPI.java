import java.util.*;

public class MostFrequentAPI {

    public static String mostFrequent(String[] requests) {
        Map<String, Integer> map = new HashMap<>();

        for (String r : requests) {
            map.put(r, map.getOrDefault(r, 0) + 1);
        }

        String ans = "";
        int max = 0;

        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                ans = key;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] requests = {"login","logout","login","fetch","login","fetch"};
        System.out.println(mostFrequent(requests));
    }
}

// o/p: login
