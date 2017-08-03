package 刷题归类.剑指offer;

/**
 * Created by Jackson on 2017/7/26.
 */
public class 树39二叉树的深度 {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right) + 1;
        //return left>right?(left+1):(right+1);
    }

}
