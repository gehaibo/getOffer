package 刷题归类.剑指offer;

import java.util.ArrayList;

/**
 * 题目：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4
 * 个数字是1,2,3,4。
 * 思路：最直接的想法就是先排序，然后前K个数即为最小的K个数。时间复杂度是O(nlogn);调优后
 * 的方法为基于快排的partition，和基于小根堆的比较替换。
 **/

public class 数组30最小的K个数 {

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
        ArrayList<Integer> result = new ArrayList<>();
        int length = input.length;
        if (length == 0 || (length > 0 && length < k)) return result;

        int l = 0;
        int r = length - 1;
        while (l < r) {
            int p = partition(input, l, r);
            if (p - l > k) {//p-l是相对位置
                r = k - 1;
            } else if (p - l < k) {
                l = p + 1;
            } else {
                break;
            }

        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> result = GetLeastNumbers_Solution(a, 4);
        System.out.println(result.toString());
    }

}
