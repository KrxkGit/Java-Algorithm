package leetcode;


import java.util.Deque;
import java.util.LinkedList;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        //doInvert(root);
        doInvertManual(root);
        return root;
    }

    /**
     * 一般递归算法
     * @param root
     */
    protected void doInvert(TreeNode root) {
        if (root == null) { // 空节点
            return;
        }
        invertTree(root.left);
        invertTree(root.right);

        exchangeLR(root);
    }

    /**
     * 手动递归：由于本例父节点不依赖与子节点的执行结果，即不依赖 父节点上下文
     * 可将父节点的处理逻辑提前到 子节点 之前
     * @param root
     */
    protected void doInvertManual(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            // 由于不依赖子节点处理结果，可提前处理当前节点
            TreeNode node = stack.pop();
            exchangeLR(node);

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }

    protected void exchangeLR(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
