package leetcode;

import java.util.Arrays;

/**
 * 根据 前序遍历 与 中序遍历 结果构造树
 * 前序遍历 【根节点，（左子树），（右子树）】
 * 中序遍历 【（左子树），根节点，（右子树）】
 * 只要 查询 出 根节点 与 左右子树，即可 递归实现。
 * 同一棵子树的结点数相同
 */
public class ConstructTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 终止条件
        if (preorder.length == 0) {
            return null;
        }
        else if (preorder.length ==  1) {
            return new TreeNode(preorder[0], null, null);
        }

        // 查询 根节点
        int root = preorder[0];
        int rootIndex = findIndex(inorder, root);
        // 左子树
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + rootIndex);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        TreeNode leftChild = buildTree(leftPreorder, leftInorder);

        // 右子树
        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + rootIndex, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        TreeNode rightChild = buildTree(rightPreorder, rightInorder);

        TreeNode rootNode = new TreeNode(root, leftChild, rightChild);
        return rootNode;
    }

    protected int findIndex(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                return i;
            }
        }
        return -1;
    }

}
