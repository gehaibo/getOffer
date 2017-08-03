package 刷题归类.剑指offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 相当于层次遍历二叉树
 */
public class 树23从上往下打印二叉树 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            list.add(t.val);

            if (t.left != null) queue.add(t.left);
            if (t.right != null) queue.add(t.right);
        }
        return list;

    }
}
