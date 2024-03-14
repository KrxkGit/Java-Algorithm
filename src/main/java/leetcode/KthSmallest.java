package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 查找 二叉树 中第 k 个小的数
 * 采用中序遍历，到 k 个结果即可停止
 */
public class KthSmallest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private int kSave, kCur;
    private List<Integer> result;
    public int kthSmallest(TreeNode root, int k) {
        this.kSave = k;
        this.kCur = 0;
        this.result = new ArrayList<>();

        Walk(root);
//        for (int i = 0; i < kSave ; i++) {
//            System.out.printf("%d ", result.get(i));
//        }
        return result.get(k - 1);
    }
    protected void Walk(TreeNode root) {
        if (root.left != null) {
            Walk(root.left);
        }
        result.add(root.val);
        kCur++;
        if (kCur >= kSave) {
            return;
        }

        if (root.right != null) {
            Walk(root.right);
        }
    }
}
