package 算法分类.常见排序.普通排序;

/**
 * Created by Jackson on 2017/8/3.
 */
public class 插入排序 {
    /**
     * 1.直接插入排序
     * 稳定排序
     * 最好：n（基本有序）,最坏：n^2,平均：n^2，空间复杂度1
     * 从第二个依次往前插入
     */

    public static void insertSort(int[] a) {
        //第0个元素不用考虑
        for (int i = 1; i < a.length; i++) {

            int temp = a[i];//每趟待插入元素
            int j;//j保存元素e要插入的位置
            for (j = i; j > 0 && a[j - 1] > temp; j--) {//j比前面大直接已经在最大位置，循环终止
                a[j] = a[j - 1];//往后移腾出要插入的位置
            }
            a[j] = temp;
        }

    }

    /**
     * 2.折半插入排序
     * 稳定排序
     * 最好：n（基本有序）,最坏：n^2,平均：n^2，空间复杂度1
     * 从第二个依次往前插入，插入时折半查找
     */
    public static void binaryInsertSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        for (int i = 1; i < a.length; i++) {

            int temp = a[i];
            //根据折半查找找到要插入的最低位置low
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (temp < a[mid])
                    high = mid - 1;

                else low = mid + 1;
            }

            //low后元素全部后移，再讲temp插入
            for (int j = i; j > low; j--) {
                a[j] = a[j - 1];
            }
            a[low] = temp;
        }
    }
    public static void main(String[] args) {
        int a[] = {4, 3, 2, 1, 12, 4, 6};
        insertSort(a);
        //binaryInsertSort(a);
        //shellSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
