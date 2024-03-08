package dp;

import java.util.LinkedList;
import java.util.Queue;

public class CanJump {
    public CanJump() {
//        int[] nums = new int[]{2,3,1,1,4};
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(whetherCanJump(nums));
    }
    public boolean whetherCanJump(int[] nums) {
        // 搜索算法
        int origin = 0;
        int target = nums[nums.length - 1];

        Queue<Integer>queue = new LinkedList<>();
        queue.offer(target);

        while (!queue.isEmpty()) {
            int prev = queue.poll();
            for (int i = 0; i < prev; i++) {
                if (canFrom(nums, i, prev)) {
                    if (i == 0) {
                        System.out.println("跳跃成功");
                        return true;
                    }
                    queue.offer(i);
                }
            }
        }
        System.out.println("跳不了");
        return false;
    }

    public boolean whetherCanJumpGreedy(int[] nums) {
        // 跳最远, 保存最远距离
        int save = 0;
        for (int i = 0; i < nums.length; i++) {
            if (save < i) {
                continue;
            }
            int temp = nums[i] + i;
            if (temp > save) {
                save = temp;
            }
        }
        if (save >= nums.length - 1) {
            return true;
        }
        return false;
    }

    protected boolean canFrom(int[] nums, int from, int to) {
        return from + nums[from] >= to;
    }
}
