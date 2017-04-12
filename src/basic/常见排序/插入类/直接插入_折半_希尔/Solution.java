package basic.常见排序.插入类.直接插入_折半_希尔;

/**
 *
 */
public class Solution {
    /**
     * 1.直接插入排序
     * 稳定排序
     * 最好：n（基本有序）,最坏：n^2,平均：n^2，空间复杂度1
     * 从第二个依次往前插入
     */

    public static void insertSort(int[] a) {
        if(a == null || a.length <= 1){
            return;
        }
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int pos = i - 1;//前面排好的最末尾

            while (pos >= 0 && temp < a[pos]) {
                a[pos + 1] = a[pos];//后移一位
                pos--;
            }
            a[pos + 1] = temp;//temp找到插入位置
        }
    }


    /**
     * 2.折半插入排序
     * 稳定排序
     * 最好：n（基本有序）,最坏：n^2,平均：n^2，空间复杂度1
     * 从第二个依次往前插入，插入时折半查找
     */
    public static void binaryInsertSort(int[] a) {
        if(a == null || a.length <= 1){
            return;
        }
        for (int i = 1; i < a.length; i++) {

            int temp = a[i];
            //根据折半查找找到要插入的最低位置low
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (temp < a[mid]) high = mid - 1;
                else low = mid + 1;
            }

            //low后元素全部后移，再讲temp插入
            for (int j = i; j > low; j--) {
                a[j] = a[j - 1];
            }
            a[low] = temp;
        }
    }

    /**
     * 3.希尔排序
     * 不稳定排序
     * 最好：n（基本有序）,最坏：n^2,平均：nlog2n，空间复杂度1
     * 从第二个依次往前插入，插入时折半查找
     */

    public static void shellSort(int[] a){
        int d=a.length/2;//增量
        while (d>=1){//增量几次，每轮需要遍历几次
            for (int i = 0; i < d; i++) {
                //下面就是插入排序，从下一个开始，间隔是d
                for (int j = i+d; j < a.length; j=j+d) {
                    int temp = a[j];
                    int pos = j - d;
                    while (pos >= 0 && a[pos] > temp) {
                        a[pos + d] = a[pos];
                        pos -= d;
                    }
                    a[pos + d] = temp;
                }
            }
            d=d/2;
        }
    }
    public static void main(String[] args) {
        int a[] = {4, 3, 2, 1, 12, 4, 6};
        //insertSort(a);
        //binaryInsertSort(a);
        //shellSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
