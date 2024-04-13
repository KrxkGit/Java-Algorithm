package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Trap2 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(height[i], height[left]) - height[top];

                answer += curWidth * curHeight;
            }
            stack.push(i);
        }
        return answer;
    }
}
