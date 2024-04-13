package leetcode;

import java.util.HashMap;

public class MajorityElement {
    private static final int destroyed = -368;
    /**
     * 方案一： 记录每项出现的次数
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }
        for (int x : nums) {
            Integer count = countMap.get(x);
            if (count == null) {
                countMap.put(x, 1);
            } else {
                countMap.put(x, count + 1);
                if (count + 1 > n / 2) {
                    return x;
                }
            }
        }
        return -1;
    }

    /**
     * 显然哈希表存储的信息是过剩的，不需要确切知道每个元素出现的次数
     * 既然 有一个元素 超过 n/2，即大于其他所有数的数量总和，即可通过其与其他数对拼
     * 这便是 摩尔投票法
     */
    public int majorityElementPlus(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
