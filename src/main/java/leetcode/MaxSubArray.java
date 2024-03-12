package leetcode;

/**
 * 可采用 动态规划思路， 本次采用前缀和方法
 */
public class MaxSubArray {
    private int[] prefix_sum;
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

//        int result = Integer.MIN_VALUE;
        return PreparePrefixSum(nums); // 提前计算前缀和


    }
    protected int PreparePrefixSum(int[] nums) {
        prefix_sum = new int[nums.length];
        int prefix_min = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix_sum[i] = nums[0];
                result = Math.max(result, prefix_sum[i] - prefix_min);
                prefix_min = Math.min(prefix_min, prefix_sum[i]);
                continue;
            }
            prefix_sum[i] = prefix_sum[i - 1] + nums[i];
            result = Math.max(result, prefix_sum[i] - prefix_min);
            prefix_min = Math.min(prefix_min, prefix_sum[i]);
        }
        return result;
    }

    protected int GetRangeSum(int l, int r) { // 闭合区间的区间和
        return prefix_sum[r] - prefix_sum[l - 1];
    }
}
