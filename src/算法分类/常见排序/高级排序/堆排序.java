package 算法分类.常见排序.高级排序;

import java.util.Arrays;

/**
 * 序号为 p 的两个孩子为 2p 与 2p+1，
 * 1.先 n/2 轮次（从最底端非叶子节点开始）建堆
 * 然后每次取堆顶，后调整堆，最终完成有序排序
 */
public class 堆排序 {


    /**
     * 2.堆排序
     * 不稳定排序
     * 全是nlogn，空间复杂度1
     */
    /**
     * 构建大顶堆
     */
    public static void adjustHeap(int[] a, int i, int len) {
        int temp, j;
        temp = a[i];
        for (j = 2 * i + 1; j < len; j = 2 * j + 1) {// 沿关键字较大的孩子结点向下筛选
            if (j < len && a[j] < a[j + 1])
                ++j; // j为关键字中较大记录的下标
            if (temp >= a[j])
                break;
            a[i] = a[j];
            i = j;
        }
        a[i] = temp;
    }

    public static void heapSort(int[] a) {
        int i, len = a.length;
        for (i = len / 2 - 1; i >= 0; i--) {// 构建一个大顶堆
            adjustHeap(a, i, len - 1);
        }
        for (i = len - 1; i >= 0; i--) {// 将堆顶记录和当前未经排序子序列的最后一个记录交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjustHeap(a, 0, i - 1);// 将a中前i-1个记录重新调整为大顶堆
        }
    }

    public static void main(String[] args) {
        int a[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
