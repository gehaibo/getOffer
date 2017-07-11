package 算法分类.常见排序.交换类.冒泡_快速;

public class Solution {

    /**
     * 1.冒泡排序
     * 稳定排序
     * 最好：n（基本有序）,最坏：n^2,平均：n^2，空间复杂度1
     * 每次相邻比较，最大的放到最终位置，依次排好n,n-1...
     */
    public static void bubbleSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        boolean isSwap ;
        //从第二个开始,共需要n-1趟
        for (int i = 1; i < a.length; i++) {
            // 每次先重置为false
            isSwap = true;
            for (int j = 0; j < a.length - i; j++) {//j从0开始，j是0至n-1，j+1到n
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
     * 2.快速排序
     * 不稳定排序
     * 最好：nlog2n（基本无序）,最坏：n^2（基本有序）,平均：nlog2n，空间复杂度nlog2n
     * 每次相邻比较，最大的放到最终位置，依次排好n,n-1...
     */
    public static int partition(int[] a, int low, int high) {
        if (a.length == 0)
            return -1;

        int key = a[low];
        while (low < high) {//等于就停止
            while (low < high && a[high] >= key) high--;//从右向左
            a[low] = a[high];

            while (low < high && a[low] <= key) low++;//从左向右
            a[high] = a[low];
        }

        a[low] = key;//把轴元素放在轴所在地位置
        return low;//返回轴所在的位置
    }

    public static void quickSort(int[] a, int low, int high) {
        if (a == null || a.length <= 1 || low >= high)
            return;

        int index = partition(a, low, high);
        quickSort(a, low, index - 1);
        quickSort(a, index + 1, high);
    }

    public static void main(String[] args) {
        int a[] = {4, 3, 2, 1, 12, 4, 6};
        bubbleSort(a);
        //quickSort(a, 0, 6);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
