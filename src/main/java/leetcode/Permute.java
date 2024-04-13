package leetcode;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Permute {
    private int[] nums;
    private int needLen;
    LinkedHashSet midResult = new LinkedHashSet<>();
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.needLen = nums.length;

        backtrace();
        return result;
    }
    private void backtrace() {
        if (midResult.size() == needLen) {
            result.add(midResult.stream().toList());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int prefetch = nums[i];
            if (midResult.contains(prefetch)) {
                continue;
            }
            midResult.add(prefetch);
            backtrace();
            midResult.remove(prefetch);
        }
    }
}
