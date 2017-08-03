package 刷题归类.剑指offer;

/**
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,
 * 否则输出No。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 思路：对于二叉搜索树的后序遍历序列，最后一个值为根节点的值，前面的序列又分为两个部分；
 * 一部分是根节点左子树的后序遍历序列，值都比根节点小，另一部分是根节点右子树的后
 * 序遍历序列，值都比根节点大。
 */

public class 树24二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        if (sequence.length == 1) return true;
        return isTreeBST(sequence, 0, sequence.length - 1);
    }

    boolean isTreeBST(int[] sequence, int start, int end) {
        //start==end对应的是叶子结点，start>end对应的是空树，这两种情况都是true
        if (start >= end) return true;
        //找到右子树开始的位子
        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) break;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) return false;
        }
        return isTreeBST(sequence, start, i - 1) && isTreeBST(sequence, i, end - 1);
    }


}
