package 上机考试.网易内推练习;

import java.util.Scanner;

/**
 * Created by Jackson on 2017/8/8.
 */
public class Main5 {

    public static int count(int[] nums, int n, int sum) {
        if (sum % n != 0) {
            return -1;
        } else {
            int ave = sum / n;
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (Math.abs(ave - nums[i]) % 2!=0) {
                    return -1;
                } else {
                    res += Math.abs(ave - nums[i]);
                }
            }
            return res / 4;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
                sum += nums[i];
            }
            System.out.println(count(nums, n, sum));
       }
    }
}
