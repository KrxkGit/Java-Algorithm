package leetcode;

import java.util.LinkedList;
import java.util.List;
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int start = 0, end = 0; // 区间的开始 与 结束(包含)
        List<String> res = new LinkedList<>();

        while (end < nums.length) {
            if (end + 1 < nums.length && nums[end + 1] == nums[end] + 1) {
                end++;
            } else {
                // 开启新区间
                if (start == end) {
                    res.add(String.format("%d", nums[start]));
                } else {
                    res.add(String.format("%d->%d", nums[start], nums[end]));
                }
                start = end + 1;
                end = start;
            }
        }
        return res;
    }
}
