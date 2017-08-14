package 刷题归类.leetCode.字符串数组;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jackson on 2017/8/11.
 */
public class Permutations46 {
    private static void swap(int[] str, int i, int j) {
    if (i != j) {
        int temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
    //static List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;
        fun(res,nums, 0);
        // Collections.sort(result);
        return res;
    }

    public static void fun(List<List<Integer>> res,int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<nums.length;i++)
                list.add(nums[i]);
            res.add(list);
        }
        //index为当前固定位
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            fun(res,nums, index + 1);
            swap(nums, i, index);//复位
        }
    }

}
