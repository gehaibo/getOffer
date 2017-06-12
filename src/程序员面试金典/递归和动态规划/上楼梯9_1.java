package 程序员面试金典.递归和动态规划;

import java.util.Arrays;

/**
 * Created by Jackson on 2017/6/6.
 */
public class 上楼梯9_1 {
    private static int[] map={0,0,0,0,0,0};
    /**
     *
     *有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。请实现一个方法，计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 1000000007
     * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
     */

   //int[] map;

    public static int countWaysDP(int n, int[] map) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (map[n] > -1) {
            return map[n];
        } else {
            map[n] = countWaysDP(n - 1, map) +
                    countWaysDP(n - 2, map) +
                    countWaysDP(n - 3, map);
            return map[n];
        }
    }
    public static int countWays(int n) {
        // write code here
        int[] map = new int[n + 1];
        Arrays.fill(map,-1);
        return countWaysDP(n,map);
    }
//    public static int countWaysRecursive(int n) {
//        if (n < 0) {
//            return 0;
//        } else if (n == 0) {
//            return 1;
//        } else {
//            return countWaysRecursive(n - 1) + countWaysRecursive(n - 2) + countWaysRecursive(n - 3);
//        }
//    }

    public static void main(String[] args) {
        //for (int i = 0; i < 30; i++) {
//            long t1 = System.currentTimeMillis();

            int c1 = countWays(1000);
//            long t2 = System.currentTimeMillis();
//            long d1 = t2 - t1;
//
//            long t3 = System.currentTimeMillis();
//            //int c2 = countWaysRecursive(i);
//            long t4 = System.currentTimeMillis();
//            long d2 = t4 - t3;
            System.out.println(5 + " " + c1 );
        //}
    }
}
