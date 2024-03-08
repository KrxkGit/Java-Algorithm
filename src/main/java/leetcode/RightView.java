package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {
    Queue<TreeNode> queue = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return result;
        }
        queue.offer(root);
//        System.out.printf("[");

        while (!queue.isEmpty()) {
            TreeNode cur = null;
            int count = queue.size();
            while (count > 0) {
                count--;
                cur = queue.poll();

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(cur.val);
        }
        return result;
    }

}
