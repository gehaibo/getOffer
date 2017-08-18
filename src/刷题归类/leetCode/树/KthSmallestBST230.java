package 刷题归类.leetCode.树;

import 刷题归类.TreeNode;

/**
 * 二叉搜索树第k小值
 */
public class KthSmallestBST230 {
    int count = 0;
    int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    public void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        count++;
        if (count == k) result = root.val;
        traverse(root.right, k);
    }
}
