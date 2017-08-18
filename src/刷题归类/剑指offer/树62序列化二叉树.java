package 刷题归类.剑指offer;

import 刷题归类.TreeNode;

/**
 * 序列化采用先序
 */
public class 树62序列化二叉树 {
    String Serialize(TreeNode root) {
        if (root == null) return " ";
        StringBuilder sb = new StringBuilder();
        Serialize(root, sb);
        return sb.toString();
    }

    void Serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        Serialize(root.left, sb);
        Serialize(root.right, sb);
    }
}