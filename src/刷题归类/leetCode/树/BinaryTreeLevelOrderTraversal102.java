package 刷题归类.leetCode.树;

import 刷题归类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jackson on 2017/8/19.
 */
public class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }

    private void levelHelper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        if (level > res.size()) {
            res.add(new ArrayList<>());
        }

        // visit 当前节点,核心输出
        res.get(level).add(root.val);
        levelHelper(res, root.left, level + 1);
        levelHelper(res, root.right, level + 1);
    }

}
