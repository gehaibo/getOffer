package 算法分类.常见排序.高级排序;

/**
 * Created by Jackson on 2017/8/3.
 */
public class 归并排序 {
    /**
     * 将已有序的子序列合并，得到完全有序的序列，先是分成二元组相互归并，然后四元组。。。
     * 稳定排序
     * 全是nlog2n，空间复杂度1
     */
    public static void mergeSort(int[] a, int left, int right) {
        // if (left < right) {
        if (left >= right) return;
        int middle = (left + right) / 2;
        // 对左边进行递归
        mergeSort(a, left, middle);
        // 对右边进行递归
        mergeSort(a, middle + 1, right);
        // 合并
        merge(a, left, middle, right);
        // }
    }

    //合并两部分
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
        mergeSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
