package leetCode.树;

/**
 * Created by Jackson on 2017/5/16.
 */
public class Binary_tree_maximum_path_sum_124 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        getMaxSumWithCurNode(root);
        return maxSum;
    }

    //从左/右子节点出发的某一条单向路径最大
    int getMaxSumWithCurNode(TreeNode curNode) {
        int lmax = 0, rmax = 0;
        int value = curNode.val;// 包含当前节点的最大路径和

        if (curNode.left != null) lmax = getMaxSumWithCurNode(curNode.left);
        if (curNode.right != null) rmax = getMaxSumWithCurNode(curNode.right);

        value = value + (lmax > 0 ? lmax : 0) + (rmax > 0 ? rmax : 0);

        if (value > maxSum) maxSum = value;
        //返回的是其中一条
        return curNode.val + Math.max(lmax > 0 ? lmax : 0, rmax > 0 ? rmax : 0);
    }
}
