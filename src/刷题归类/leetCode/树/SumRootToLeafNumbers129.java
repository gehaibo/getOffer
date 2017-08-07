package 刷题归类.leetCode.树;

/**
 * Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path1->2->3which represents the number123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 * 1
 * / \
 * 2   3
 * <p>
 * The root-to-leaf path1->2represents the number12.
 * The root-to-leaf path1->3represents the number13.
 * Return the sum = 12 + 13 =25.
 */
public class SumRootToLeafNumbers129 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int preorderSumNumbers(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return preorderSumNumbers(root.left, sum) + preorderSumNumbers(root.right, sum);
    }

    //先序遍历的思想(根左右)+数字求和(每一层都比上层和*10+当前根节点的值)
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;
        return preorderSumNumbers(root, sum);

    }
}
