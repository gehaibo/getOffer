package 刷题归类.剑指offer.树25.二叉树中和为某一值得路径;

import java.util.ArrayList;

/**
 * Created by Jackson on 2017/7/20.
 */

public class Main {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return listAll;

        target -= root.val;
        if (target >= 0) {
            //每次先加入节点，找不到再回退
            list.add(root.val);
            if (target == 0 && root.left == null && root.right == null) {
                //不重新new的话从始至终listAll中所有引用都指向了同一个一个list
                listAll.add(new ArrayList<>(list));
            }
            if (root.left != null) FindPath(root.left, target);
            if (root.right != null) FindPath(root.right, target);
            //递归到叶子节点如果还没有找到路径，就要回退到父节点继续寻找，依次类推
            list.remove(list.size() - 1);
        }
        return listAll;
    }

}
