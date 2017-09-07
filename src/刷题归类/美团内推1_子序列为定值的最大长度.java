package 刷题归类;

import java.util.Scanner;

/**
 * l和h两个指针，h固定，l依次试探，进入循环前提是cur>res
 */
public class 美团内推1_子序列为定值的最大长度 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }
        int k = in.nextInt();

        int res = 0;
        for (int hi = n - 1; hi >= 0; hi++) {//每次都从0开始
            int lo = 0, st = sum;
            while (lo <= hi && (hi - lo + 1 > res)) {
                if (st % k == 0) {
                    res = hi - lo + 1;
                    break;
                }
                st-=arr[lo];//找不到缩小窗口
                lo++;
            }
            //hi再缩小
            sum -= arr[hi];
        }
        System.out.println(res);
    }
}
