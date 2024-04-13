package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 对每个元素 维护一个索引列表, 为了加快速度，采用数组列表
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> positionList = hashMap.get(nums[i]);
            if (positionList == null) {
                positionList = new ArrayList<>();
                hashMap.put(nums[i], positionList);
                positionList.add(i);
            } else {
                // 检查是否在 k邻域 内存在重复元素
                if (Math.abs(positionList.get(positionList.size() - 1) - i) <= k) {
                    return true;
                }
                positionList.add(i);
            }
        }
        return false;
    }
}
