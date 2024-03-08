package leetcode;

import java.util.HashSet;
/**
 * 最长连续序列
 */
public class LCS {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int maxLen = 0;
        for (int item : nums) {
            hashSet.add(item);
        }
        for (int item : nums) {
            // 剪枝，若 item - 1 存在， 则无需遍历
            if (hashSet.contains(item - 1)) {
                continue;
            }
            int len = 0;
            int k = 0;
            while (true) {
                if (hashSet.contains(item + k)) {
                    k += 1;
                    len++;
                } else {
                    break;
                }
            }
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }
}
