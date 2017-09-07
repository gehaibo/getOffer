package 刷题归类.剑指offer;

import 刷题归类.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 两个变量，cur当前层还没有打印节点，next下一层节点数
 */
public class 树60把二叉树打印成多行 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();

        if (pRoot == null) return ret;

        q.add(pRoot);
        int now = 1, next = 0;
        while (!q.isEmpty()) {
            TreeNode t = q.remove();
            now--;
            tmp.add(t.val);
            if (t.left != null) {
                q.add(t.left);
                next++;
            }
            if (t.right != null) {
                q.add(t.right);
                next++;
            }
            if (now == 0) {
                ret.add(new ArrayList<>(tmp));
                tmp.clear();
                now = next;
                next = 0;
            }
        }
        return ret;
    }
}
