package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
