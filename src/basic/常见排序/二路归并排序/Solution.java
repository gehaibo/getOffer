package basic.常见排序.二路归并排序;

/**
 * Created by ghb on 2017/4/10.
 */
public class Solution {

    /**
     * 二路归并排序
     * 稳定排序
     * 全是nlog2n，空间复杂度1
     */
    public static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            // 对左边进行递归
            mergeSort(a, left, middle);
            // 对右边进行递归
            mergeSort(a, middle + 1, right);
            // 合并
            merge(a, left, middle, right);
        }
    }

    private static void merge(int[] a, int left, int middle, int right) {
        int[] tmpArr = new int[right - left + 1];
        int pos = 0;

        int i = left;// 左边起始位置
        int j = middle + 1; // 右边起始位置
        while (i <= middle && j <= right) {
            // 从两个数组中选取较小的数放入中间数组
            if (a[i] <= a[j]) {
                tmpArr[pos++] = a[i++];
            } else {
                tmpArr[pos++] = a[j++];
            }
        }
        // 将剩余的部分放入中间数组
        while (i <= middle) {
            tmpArr[pos++] = a[i++];
        }
        while (j <= right) {
            tmpArr[pos++] = a[j++];
        }
        // 将中间数组复制回原数组
        int start = 0;
        while (left <= right) {
            a[left++] = tmpArr[start++];
        }
    }

    public static void main(String[] args) {
        int a[] = {4, 3, 2, 1, 12, 4, 6};
        mergeSort(a,0,a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
