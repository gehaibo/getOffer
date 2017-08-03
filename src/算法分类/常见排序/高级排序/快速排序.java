package 算法分类.常见排序.高级排序;

import java.util.Random;

/**
 * 排序相关
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
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partion(int[] arr, int l, int r) {
        int s = new Random().nextInt(r - l + 1) + l;
        swap(arr, l, s);
        int v = arr[l];

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
