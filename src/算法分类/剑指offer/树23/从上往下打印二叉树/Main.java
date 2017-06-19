package 算法分类.剑指offer.树23.从上往下打印二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 相当于层次遍历二叉树
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
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list=new ArrayList<>();
        if (root==null) return list;

        Deque<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode t=queue.poll();
            list.add(t.val);

            if (t.left!=null) queue.add(t.left);
            if (t.right!=null) queue.add(t.right);
        }
        return list;

    }
}
