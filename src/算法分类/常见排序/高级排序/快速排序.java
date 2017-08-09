package 算法分类.常见排序.高级排序;

import java.util.Random;

/**
 * 快速排序使用分治的思想，通过一趟排序将待排序列分割成两部分，其中一部分记录的关键字均比另一部分记录的关键字小。之后分别对这两部分记录继续进行排序，以达到整个序列有序的目的
 *
 * (1)选择基准：在待排序列中，按照某种方式挑出一个元素，作为 "基准"（pivot）

   (2)分割操作：以该基准在序列中的实际位置，把序列分成两个子序列。此时，在基准左边的元素都比该基准小，在基准右边的元素都比基准大

   (3)递归地对两个序列进行快速排序，直到序列为空或者只有一个元素。
 */
public class 快速排序 {

    private static void quickSort(int arr[], int l, int r) {
        if (l >= r) return;

        int p = partion(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    /**
     * 优化放置重复
     */
     public static int partion(int[] arr, int l, int r) {
        int s = new Random().nextInt(r - l + 1) + l;
        swap(arr, l, s);
        int v = arr[l];//第一个记录要分界的元素大小

        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i] < v) i++;
            while (r >= l + 1 && arr[j] > v) j--;
            if (i > j) break;//终止条件
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);//l换到适合的位置
        return j;
    }

    public static void swap(int[] items, int a, int b) {
        int t;
        t = items[a];
        items[a] = items[b];
        items[b] = t;
    }


    public static void main(String[] args) {

        int[] data = new int[]{4, 5, 4, 2, 6, 1, 0, 8};
        quickSort(data, 0, data.length - 1);
        for (int n : data) {
            System.out.print(n + " ");
        }
    }
}
