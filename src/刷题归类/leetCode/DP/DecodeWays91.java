package 刷题归类.leetCode.DP;

/**
 * 此题类似调台阶。f(n)=f(n-1)+f(n-2)
 * 但是要判断没一次拆分是否符合条件
 */
public class DecodeWays91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;//dp[0] means an empty string will have one way to decode, dp[1] means the way to decode a string of size 1
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= length; i++) {
            int f1 = Integer.valueOf(s.substring(i - 1, i));
            int f2 = Integer.valueOf(s.substring(i - 2, i));
            if (f1 >= 1 && f1 <= 9)
                dp[i] += dp[i - 1];
            if (f2 >= 10 && f2 <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[length];
    }
}
