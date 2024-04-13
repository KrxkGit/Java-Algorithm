package leetcode;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[]dp = new int[nums.length];
        // Init
        dp[0] = 1;
        int save = 1;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            save = Math.max(save, dp[i]);
        }
        return save;
    }
}
