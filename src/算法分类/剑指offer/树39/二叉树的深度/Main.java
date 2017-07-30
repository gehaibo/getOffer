package 算法分类.剑指offer.树39.二叉树的深度;

/**
 * Created by Jackson on 2017/7/26.
 */
public class Main {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public int TreeDepth(TreeNode root) {
        if (root==null) return 0;

        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        return Math.max(left,right)+1;
        //return left>right?(left+1):(right+1);
    }

}
