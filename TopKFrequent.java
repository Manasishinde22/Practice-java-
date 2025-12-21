import java.util.*;

public class TopKFrequent {

    public static int[] topK(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums)
            freq.put(n, freq.getOrDefault(n, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        for (int key : freq.keySet()) {
            pq.add(new int[]{key, freq.get(key)});
            if (pq.size() > k)
                pq.poll();
        }

        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty())
            res[i++] = pq.poll()[0];

        return res;
    }

    // ✅ MAIN METHOD
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topK(nums, 2)));
    }
}

// o/p: [2, 1]
