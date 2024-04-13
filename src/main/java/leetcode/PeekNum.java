package leetcode;

public class PeekNum {
    private int[] prefix_sum;
    public int findPeakElement(int[] nums) {
        if (nums.length == 2) {
            if (nums[1] > nums[0]) {
                return 1;
            } else {
                return 0;
            }
        }
        CalPrefix_sum(nums);
        Integer save = prefix_sum[0];
        boolean ascend = false;
        for (int i = 1; i < nums.length; i++) {
            Integer res = prefix_sum[i] - prefix_sum[i - 1];
            if (res < save) {
                // 索引为答案索引
                return i - 1;
            } else {
                save = res;
                ascend = true;
            }
        }
        if (ascend) {
            return nums.length - 1;
        }
        else {
            return 0;
        }
    }

    protected void CalPrefix_sum(int[] nums) {
        prefix_sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix_sum[i] = nums[i];
            } else {
                prefix_sum[i] = prefix_sum[i-1] + nums[i];
            }
        }
    }
}
