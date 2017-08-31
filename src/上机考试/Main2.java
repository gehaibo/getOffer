package 上机考试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jackson on 2017/8/26.
 */
public class Main2 {
//    //快排思想的partition
//    public static int partition(int[] a, int low, int high) {
//        if (a.length == 0) return -1;
//
//        int key = a[low];
//        while (low < high) {//等于就停止
//            while (low < high && a[high] >= key) high--;//从右向左
//            a[low] = a[high];
//
//            while (low < high && a[low] <= key) low++;//从左向右
//            a[high] = a[low];
//        }
//
//        a[low] = key;//把轴元素放在轴所在地位置
//        return low;//返回轴所在的位置
//    }
//
//    public static int getK(int[] input, int k) {
//        int length = input.length;
//        if (length == 0 || (length > 0 && length < k)) return -1;
//
//        int l = 0;
//        int r = length - 1;
//        while (l < r) {
//            int p = partition(input, l, r);
//            if (r - p > k) {//p-l是相对位置
//                l = p + 1;
//            } else if (p - l < k) {
//                r = p - 1;
//            } else {
//                break;
//            }
//
//        }
//        return input[k];
//    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // while (in.hasNextInt()) {//注意while处理多个case
        String string = in.nextLine();
        String[] a = string.trim().split(" ");
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = Integer.parseInt(a[i]);
        }
        int k = in.nextInt();
//        System.out.println(getK(arr, a.length - k));
        Arrays.sort(arr);
        System.out.println(arr[arr.length - k]);
        //  }
    }
}
