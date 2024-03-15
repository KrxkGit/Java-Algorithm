package leetcode;

/**
 * 双指针要考虑 移动单一指针 或 同时按一定关系移动双指针
 * 每一种指针状态 在结果上都要实现依赖覆盖。
 */
public class MaxArea {
    private int save = 0;
    private int[] saveHeight;
    public int maxArea(int[] height) {
        if (height.length <= 2) {
            return Math.min(height[0], height[1]) * 1;
        }
        this.saveHeight = height;
        int n = height.length;

        int i = 0, j = n - 1;
        while (i < j) {
            change(i, j);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return save;
    }
    protected void change(int i, int j) {
        int lower = Math.min(saveHeight[i], saveHeight[j]);
        int area = (j - i) * lower;
        save = Math.max(save, area);
    }
}
