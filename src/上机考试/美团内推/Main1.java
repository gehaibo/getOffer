package 上机考试.美团内推;

import java.util.Scanner;

/**
 * Created by Jackson on 2017/8/31.
 */
public class Main1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // while (in.hasNextInt()) {//注意while处理多个case
        int size = in.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
//
//        int res = 0;
//        int sum1 = 0;
//        for (int i = 0; i < size; i++) {
//            sum1 += arr[i];
//        }
//        if (sum1 % k == 0){
//            System.out.println(size);
//            return;
//        }
//
//
//        for (int i = size ; i < size; i++) {
//            int l = 0, r = l + i - 1;
//            int sum = 0;
//            while (r <= size - 1) {
//                for (int j = l; j <= r; j++) {
//                    sum += arr[j];
//                }
//                if (sum != 0 && (sum % k == 0)) {
//                    res = Math.max(res, i);
//                    continue;
//                } else {
//                    l++;
//                    r++;
//                }
//            }
//        }
//
//        System.out.println(res);
    }
    //}
}
