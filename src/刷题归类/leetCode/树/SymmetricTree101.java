package 刷题归类.leetCode.树;


import 刷题归类.TreeNode;

/**
 * 判断自己是否是对称的
 * <p>
 * 左子树的左和右子树的右
 * 左子树的右和右子树的左
 * 是否对称
 */
public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        //空子树是对称的
        return root == null || isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        //有一个为空，或全为空
        if (left == null || right == null) return left == right;
        //全不为空，相等就继续比较
        if (left.val != right.val) return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
