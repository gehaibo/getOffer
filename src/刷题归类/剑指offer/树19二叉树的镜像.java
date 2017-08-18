package 刷题归类.剑指offer;

import 刷题归类.TreeNode;

import java.util.Stack;

/**
 * 题目：操作给定的二叉树，将其变换为源二叉树的镜像。
 * <p>
 * 思路：先前序遍历这棵树的每个结点，如果遍历到的结点有子结点，就交换它的两个子节点，
 * 当交换完所有的非叶子结点的左右子结点之后，就得到了树的镜像
 */


public class 树19二叉树的镜像 {
    //递归实现
    public void Mirror(TreeNode root) {
        if (root == null) return;
        if (root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        if (root.left != null) Mirror(root.left);
        if (root.right != null) Mirror(root.right);
    }

    //非递归
    public void Mirror1(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode t = s.pop();
            if (t.left != null || t.right != null) {
                TreeNode temp = t.left;
                t.left = t.right;
                t.right = temp;
            }

            if (t.left != null) s.push(t.left);
            if (t.right != null) s.push(t.right);
        }
    }
}
