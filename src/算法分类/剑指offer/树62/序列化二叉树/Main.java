package 算法分类.剑指offer.树62.序列化二叉树;

/**
 * 序列化采用先序
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

    String Serialize(TreeNode root) {
        if (root == null) return " ";
        StringBuilder sb = new StringBuilder();
        Serialize(root, sb);
        return sb.toString();
    }

    void Serialize(TreeNode root, StringBuilder sb) {
        if (root==null){
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        Serialize(root.left,sb);
        Serialize(root.right,sb);
    }

//    TreeNode Deserialize(String str) {
//
//    }
}
