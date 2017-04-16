package 剑指offer.面试题30.最小的K个数;

/**
 * 题目：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4
 *      个数字是1,2,3,4。
 * 思路：最直接的想法就是先排序，然后前K个数即为最小的K个数。时间复杂度是O(nlogn);调优后
 *		的方法为基于快排的partition，和基于小根堆的比较替换。
 **/

public class Main {

    //快排思想的partition
    public int partition(int[] input, int low, int high) {
        //随机选择一个数
        int key = input[low];
        while (low < high) {
            while(low < high && input[high] >= key)
                high --;
            swap(input, low, high);
            while(low < high && input[low] <= key)
                low ++;
            swap(input, low, high);
        }
        return low;
    }
    public void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
