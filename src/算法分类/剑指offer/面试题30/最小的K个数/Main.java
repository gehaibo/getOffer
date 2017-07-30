package 算法分类.剑指offer.面试题30.最小的K个数;

import java.util.ArrayList;

/**
 * 题目：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4
 * 个数字是1,2,3,4。
 * 思路：最直接的想法就是先排序，然后前K个数即为最小的K个数。时间复杂度是O(nlogn);调优后
 * 的方法为基于快排的partition，和基于小根堆的比较替换。
 **/

public class Main {

    //快排思想的partition
    public static int partition(int[] a, int low, int high) {
        if (a.length == 0) return -1;

        int key = a[low];
        while (low < high) {//等于就停止
            while (low < high && a[high] >= key) high--;//从右向左
            a[low] = a[high];

            while (low < high && a[low] <= key) low++;//从左向右
            a[high] = a[low];
        }

        a[low] = key;//把轴元素放在轴所在地位置
        return low;//返回轴所在的位置
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        int length = input.length;
        ArrayList<Integer> result = new ArrayList<>();
        if (length == 0 || (length > 0 && length < k)) return result;

        int index = partition(input, 0, length - 1);
        while (index != k - 1) {
            if (index < k) {
                index = partition(input, index + 1, length - 1);
            } else {
                index = partition(input, 0, index - 1);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> result = GetLeastNumbers_Solution(a, 8);
        System.out.println(result.toString());
    }

}
