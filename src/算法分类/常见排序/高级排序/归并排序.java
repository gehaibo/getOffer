package 算法分类.常见排序.高级排序;

/**
 * Created by Jackson on 2017/8/3.
 */
public class 归并排序 {
    /**
     * 将两个已经排序的序列合并成一个序列的操作
     * 将已有序的子序列合并，得到完全有序的序列，
     * 先是分成二元组排序，然后四元组排序。。。  直到最后剩两部分，最后两个有序数组merge
     * 稳定排序
     * 全是nlog2n，空间复杂度1
     */
    public static void mergeSort(int[] a, int l, int r) {

        if (l >= r) return;
        int mid = l + (r - l) / 2;
        // 对左边和进行归并
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);

        // 合并
        merge(a, l, mid, r);

    }

    //合并两部分
    private static void merge(int[] a, int left, int middle, int right) {
        //辅助空间，两个归并的空间依次复制到这里
        int[] tmpArr = new int[right - left + 1];
        int pos = 0;//要插入位置

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
        while (i <= middle) {//i未归并完
            tmpArr[pos++] = a[i++];
        }
        while (j <= right) {//j未归并完
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
