package 刷题归类.leetCode.树;

import 刷题归类.TreeNode;

/**
 * Created by Jackson on 2017/9/4.
 */
public class InvertBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
