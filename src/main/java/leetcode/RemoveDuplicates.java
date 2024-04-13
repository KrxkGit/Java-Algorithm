package leetcode;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }

    public int removeDuplicatesPlus(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return len;
        }
        // fast 为当前检查到的指针， slow 为待替换的位置
        int fast = 2, slow = 2;
        while (fast < len) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
