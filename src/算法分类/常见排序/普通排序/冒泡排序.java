package 算法分类.常见排序.普通排序;

import java.util.Arrays;

/**
 * 冒泡排序是一种交换排序，它的基本思想是：两两比较序列中相邻记录的关键字，如果反序则交换，直到没有反序的记录为止。它的运行过程如下（以升序排序为例）：
 * <p>
 * 　　比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 　　对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 　　针对所有的元素重复以上的步骤，除了最后一个。
 * 　　持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class 冒泡排序 {
    /**
     * 1.冒泡排序
     * 稳定排序
     * 最好：n（基本有序）,最坏：n^2,平均：n^2，空间复杂度1
     * 每次相邻比较，最大的放到最终位置，依次排好n,n-1...
     */
    public static void bubbleSort(int[] a) {
        boolean isSwap;

        for (int i = 1; i < a.length; i++) {//控制趟数
            // 每次先重置为false
            isSwap = true;
            //每次都从第一个开始，依次比较向上
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                    isSwap = false;
                }
            }
            if (isSwap)
                break;
        }
    }

    /**
     * 下面对其进行优化，设置一个标志，如果这一趟发生了交换，则为true，否则为false。明显如果有一趟没有发生交换，说明排序已经完成。
     * @param args
     */

    /**
     * 再做进一步的优化。如果有100个数的数组，仅前面10个无序，后面90个都已排好序且都大于前面10个数字，
     * 那么在第一趟遍历后，最后发生交换的位置必定小于10，且这个位置之后的数据必定已经有序了，记录下这位置，第二次只要从数组头部遍历到这个位置就可以了。
     */
    static void BubbleSort3(int a[], int n) {
        int k;
        int flag;

        flag = n;
        while (flag > 0) {
            k = flag;//k记录每次需要循环的
            flag = 0;
            for (int j = 1; j < k; j++)
                if (a[j - 1] > a[j]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                    flag = j;//每次更新flag
                }
        }
    }

    public static void main(String[] args) {
        int a[] = {4, 3, 2, 1, 12, 4, 6};
        //bubbleSort(a);
        BubbleSort3(a, 7);
        System.out.println(Arrays.toString(a));

    }
}
