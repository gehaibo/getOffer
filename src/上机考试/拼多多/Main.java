package 上机考试.拼多多;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jackson on 2017/8/1.
 */
public class Main {
    //private static boolean invalidInput = false;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (reader.hasNextInt()) {
            int m = reader.nextInt();
            int[] nums = new int[m];
            for (int i = 0; i < m; i++) {

                nums[i] = reader.nextInt();
            }
//            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
//            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
//
//            for (int n : nums) {
//                if (n > max1) {
//                    max3 = max2;
//                    max2 = max1;
//                    max1 = n;
//                } else if (n > max2) {
//                    max3 = max2;
//                    max2 = n;
//                } else if (n > max3) {
//                    max3 = n;
//                }
//
//                if (n < min1) {
//                    min2 = min1;
//                    min1 = n;
//                } else if (n < min2) {
//                    min2 = n;
//                }
//            }
//
//            int result1 = max1 * max2 * max3;
//            int result2 = max1 * min1 * min2;
//            if (result1 >= result2) {
//                System.out.println(result1);
//            } else {
//                System.out.println(result2);
//            }
            Arrays.sort(nums);
            int n = nums.length;
            int s = nums[n-1] * nums[n-2] * nums[n-3];
            s = Math.max(s, nums[n-1] * nums[n-2] * nums[0]);
            s = Math.max(s, nums[n-1] * nums[1] * nums[0]);
            s = Math.max(s, nums[2] * nums[1] * nums[0]);
            System.out.println(s);
        }
    }
//        int result1, result2;
//        Arrays.sort(arr);
//        result1 = arr[0] * arr[1] * arr[arr.length - 1];
//        result2 = arr[arr.length - 1] * arr[arr.length - 2] * arr[0];
//        if (result1 >= result2){
//            System.out.println(result1);
//        }
//        else
//            System.out.println(result2);

//
//            int res=1;
//
//            int[] maxNums = {0, 0, 0};  // 三个最大的正数  并按照大小顺序依次排列
//            int[] minNums = {0, 0};  // 两个最小的负数  同上
//            int len = arr.length;
//
//            for(int i = 0; i < len; i++){
//                if(arr[i] < 0){
//                    for(int j = 0; j < 2; j++){
//                        // 当前项和 minNums 第一项开始比较
//                        // 如果 arr 小 则 插入到 minNums 当前项同时把最后一项删除
//                        if(minNums[j] > arr[i]){
//                            minNums.splice(j, 0, arr[i]);
//                            minNums.pop();
//                            break;
//                        }
//                    }
//                }else {
//                    for(int k = 2; k >= 0; k--){
//                        if(maxNums[k] < arr[i]){
//                            maxNums.splice(k + 1, 0, arr[i]);
//                            maxNums.shift();
//                            break;
//                        }
//                    }
//                }
//            }
//
//            if(maxNums[0] * maxNums[1] > minNums[0] * minNums[1]){
//                res = maxNums;
//            }else {
//                res = minNums.concat(maxNums[2]);
//            }
//            System.out.println(res);
}
//   }


