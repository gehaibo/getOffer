package leetCode.树;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 * 1
 * /  \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 **/
public class Sum_Root_to_Leaf_Numbers_129 {
    //思路：先序遍历，每个节点的值等于---上层节点和*10+当前根节点的值
    public int preorderSumNumbers(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) return sum;
        return preorderSumNumbers(root.left, sum) + preorderSumNumbers(root.right, sum);
    }

    //先序遍历的思想(根左右)+数字求和(每一层都比上层和*10+当前根节点的值)
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;
        return preorderSumNumbers(root, sum);
    }
}
