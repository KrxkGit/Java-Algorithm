package leetcode;

public class SlideWin {
    public SlideWin() {
        int[] nums = {5,1,3,5,10,7,4,9,2,8};
        System.out.println(minSubArrayLen(15, nums));
    }

    public int minSubArrayLenBrute(int target, int[] nums) {
        int sum = 0;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            if (sum >= target) {
                int l = 1;
                if (l < len) {
                    len = l;
                    break;
                }
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    int l = j - i + 1;
                    if (l < len) {
                        len = l;
                    }
                }
            }
        }
        if (len == Integer.MAX_VALUE) {
            return 0;
        } else {
            return len;
        }
    }
    public int minSubArrayLen(int target, int[] nums) {
        // 暴力过程中产生的新信息：滑动窗口中间部分的求和可重复利用
        int len = 0; // 窗口长度
        int sum = 0;
        int minLen = Integer.MAX_VALUE; // 保存最小窗口长度

        for (int i = 0; i < nums.length; i++) {
            len++;
            sum += nums[i];
            if (sum >= target) {
                int removeIndex = i - len;
                for (; true; ) {
                    removeIndex++;
                    if (removeIndex < 0 || removeIndex >= nums.length) {
                        break;
                    }
                    if (sum - nums[removeIndex] >= target) {
                        len--;
                        sum -= nums[removeIndex];
                    } else {
                        break;
                    }
                }
                minLen = Math.min(minLen, len);
            }
        }
        if (sum < target) {
            return 0;
        } else {
            return minLen;
        }
    }
}
