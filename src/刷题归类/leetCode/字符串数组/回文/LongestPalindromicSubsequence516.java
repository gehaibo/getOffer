package 刷题归类.leetCode.字符串数组.回文;

/**
 * 最长回文子序列
 * "bbbab"
 * 4
 * ---
 * bbbb
 */
public class LongestPalindromicSubsequence516 {
    /**
     * dp[i][j]表示s[i .. j]的最大回文子串长度
     * 最终求的是1到n，所以i从后往前，j一次从i加1
     */
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
