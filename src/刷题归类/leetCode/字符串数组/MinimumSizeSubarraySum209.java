package 刷题归类.leetCode.字符串数组;

/**
 * 数组最短连续子数组和sum>=s
 * <p>
 * 此题用滑动窗口解法
 * l，r  r先向后走，直到sum>=s
 * sum>=s，l右移，减小窗口，<s,r右移，扩大窗口
 */
public class MinimumSizeSubarraySum209 {
    public static int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 2, 4, 3};
        minSubArrayLen(7, a);
    }
}
