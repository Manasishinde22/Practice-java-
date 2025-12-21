import java.util.*;

public class AssignmentDP {

    static int[][] cost;
    static int[] dp;

    public static int solve(int mask, int n) {
        if (mask == (1 << n) - 1)
            return 0;

        if (dp[mask] != -1)
            return dp[mask];

        int person = Integer.bitCount(mask);
        int ans = Integer.MAX_VALUE;

        for (int task = 0; task < n; task++) {
            if ((mask & (1 << task)) == 0) {
                ans = Math.min(ans,
                    cost[person][task] +
                    solve(mask | (1 << task), n));
            }
        }
        return dp[mask] = ans;
    }

    public static void main(String[] args) {
        cost = new int[][]{
            {9,2,7},
            {6,4,3},
            {5,8,1}
        };
        int n = 3;
        dp = new int[1 << n];
        Arrays.fill(dp, -1);

        System.out.println(solve(0, n));
    }
}

// o/p: 9
