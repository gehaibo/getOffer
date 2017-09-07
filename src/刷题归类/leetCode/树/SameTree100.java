package 刷题归类.leetCode.树;

import 刷题归类.TreeNode;

/**
 * Created by Jackson on 2017/9/4.
 */
public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}
