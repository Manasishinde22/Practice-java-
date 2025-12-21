import java.util.*;

public class MinCostCuts {

    public static int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;

        for (int i = 0; i < m; i++)
            arr[i + 1] = cuts[i];

        Arrays.sort(arr);

        int[][] dp = new int[m + 2][m + 2];

        for (int len = 2; len < m + 2; len++) {
            for (int i = 0; i + len < m + 2; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                        dp[i][k] + dp[k][j] + (arr[j] - arr[i]));
                }
            }
        }
        return dp[0][m + 1];
    }

    public static void main(String[] args) {
        int[] cuts = {1,3,4,5};
        System.out.println(minCost(7, cuts));
    }
}

// o/p: 16
