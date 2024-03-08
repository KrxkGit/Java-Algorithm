package leetcode;


import java.util.Stack;

public class CommonParent {
    Stack<TreeNode> pList = new Stack<>();
    Stack<TreeNode> qList = new Stack<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        walk(root, p, pList);
        walk(root, q, qList);

        TreeNode save = root;

        while (!pList.isEmpty() && !qList.isEmpty()) {
            TreeNode l = pList.pop();
            TreeNode r = qList.pop();
            if (l == r) {
                save = l;
            } else {
                break;
            }
        }
        return save;
    }
    protected boolean walk(TreeNode root, TreeNode t, Stack<TreeNode> nodeList) {
        if (root == t) {
            return true;
        }

        if (root.left !=null && walk(root.left, t, nodeList)) {
            nodeList.push(root.left);
            return true;
        } else if (root.right != null && walk(root.right, t, nodeList)) {
            nodeList.push(root.right);
            return true;
        } else {
            System.out.println("Not Found: " + t.val + " at: " + root.val);
            return false;
        }
    }
}




class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
