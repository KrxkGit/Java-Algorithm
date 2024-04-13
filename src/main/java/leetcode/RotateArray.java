package leetcode;

/**
 * 代码存在 bug
 */
public class RotateArray {
    int[] nums;
    public void rotate(int[] nums, int k) {
        this.nums = nums;

        int s = nums.length - k; // k 个的起始索引
        for (int i = s; i < nums.length; i++) {
            /**
             * 环形替换方案，此方案由于 k 区域结构会被破坏 而 发生错误
             */
            int saveVal = nums[i];

            for (int cur = cycle(i + k); cur != i; cur = cycle(cur + k)) {
                int temp = nums[cur];
                nums[cur] = saveVal;
                saveVal = temp;
            }
        }
    }

    protected int cycle(int index) { // 循环索引的位置
        return index % nums.length;
    }
}
