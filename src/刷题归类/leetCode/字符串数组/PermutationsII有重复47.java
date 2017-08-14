package 刷题归类.leetCode.字符串数组;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class PermutationsII有重复47 {
    /**
     * 排列问题，按照排列思想，遍历每个位置，对每个位置每次都从集合中选一个未被选的元素。所以排列个数为n!，时间复杂度为n！。
     * 对传来的数组利用交换，每次把选择的元素交换到该位置上，再递归后面位置。对与有重复元素，要避免交换重复的，所以判断如果出现过就不再交换。
     */
    private static void swap(int[] str, int i, int j) {
        if (i != j) {
            int temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        permute(res, nums, 0);
        return res;
    }

    public static void permute(List<List<Integer>> res, int[] nums, int index) {
        if (index == nums.length-1) {
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < nums.length; i++)
                list.add(nums[i]);

            res.add(list);
        }
        for (int i = index; i < nums.length; i++) {
            boolean flag = false;               //flag题2使用，判断重复的元素，如果是就不交换
            for (int j = index + 1; j < i; j++) {
                if (nums[j] == nums[i])
                    flag = true;
            }
            if (flag)
                continue;
            swap(nums, index, i);
            permute(res, nums, index + 1);//后面继续递归
            swap(nums, index, i);

        }
    }
}
