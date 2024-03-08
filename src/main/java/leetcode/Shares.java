package leetcode;

public class Shares {
    public Shares() {
    }
    public int maxProfitBrute(int[] nums) {
        // 低买高卖
        int save = 0;
        for (int i = 0; i < nums.length -1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                int diff = nums[j] - nums[i];
                save = save > diff ? save : diff;
            }
        }
        return save;
    }
    public int maxProfit(int[] nums) {
        // 抄底，最高点抛出
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minPrice) {
                minPrice = nums[i];
            } else if (nums[i] - minPrice > maxProfit) {
                maxProfit = nums[i] - minPrice;
            }
        }
        return maxProfit;

    }
}
