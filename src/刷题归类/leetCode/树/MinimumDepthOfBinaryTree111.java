package 刷题归类.leetCode.树;

/**
 * Created by Jackson on 2017/5/12.
 */

public class MinimumDepthOfBinaryTree111 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        /**
         * 二叉树的最小深度，等于左右子树深度较小者+1。
         * 这里需要注意的问题是：求最大深度的时候，只需要比较左右子树的深度，取较大者+1就行了；
         * 但是求最小深度的时候，需要区分双子树与单子树，双子树时，深度较小者+1，单子树时（即左右子树有一颗为空时）为深度较大者+1。
         * 主要思想仍然是后序递归遍历。
         */
        public int run(TreeNode root) {
            if (root == null) return 0;
            int l = run(root.left);
            int r = run(root.right);

            //因为l和r至少有一个是0，即当前节点要么有一个分支，要么是根节点。
            if (l == 0 || r == 0) return 1 + l + r;
            return (l > r ? r : l) + 1;
        }

    }
}