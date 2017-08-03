package 算法分类.常见排序.高级排序;

/**
 * Created by Jackson on 2017/8/3.
 */
public class 希尔排序 {

    /**
     * 3.希尔排序
     * 不稳定排序
     * 最好：n（基本有序）,最坏：n^2,平均：nlogn，空间复杂度1
     * 从第二个依次往前插入，插入时折半查找
     */

    public static void shellSort(int[] a) {
        int d = a.length / 2;//增量
        while (d >= 1) {//增量几次，每轮需要遍历几次
            for (int i = 0; i < d; i++) {
                //下面就是插入排序，从下一个开始，间隔是d
                for (int j = i + d; j < a.length; j = j + d) {
                    int temp = a[j];
                    int pos = j - d;
                    while (pos >= 0 && a[pos] > temp) {
                        a[pos + d] = a[pos];
                        pos -= d;
                    }
                    a[pos + d] = temp;
                }
            }
            d = d / 2;
        }
    }

    public static void main(String[] args) {
        int a[] = {4, 3, 2, 1, 12, 4, 6};
        //insertSort(a);
        //binaryInsertSort(a);
        shellSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
