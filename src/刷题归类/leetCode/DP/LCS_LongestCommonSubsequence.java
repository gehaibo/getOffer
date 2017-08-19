package 刷题归类.leetCode.DP;

/**
 * 返回两个字符串最长公共子序列（不连续）
 * 给出 "ABCD" 和 "EACB"，这个LCS是"AC"返回 2
 * <p>
 * dp（m,n）是s1[0,1...m]和s2[0,1,2...n]最长子序列长度
 * if s1[m]=s2[n]
 * dp（m,n）= 1+dp（m-1,n-1）
 * if s1[m]!=s2[n]
 * dp（m,n）= Max{dp（m-1,n）,dp(m,n-1)}
 */
public class LCS_LongestCommonSubsequence {
    static int longestCommonSubstring(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int len1 = ch1.length, len2 = ch2.length;
        int[][] dp = new int[len1][len2];
        dp[0][0] = (ch1[0] == ch2[0]) ? 1 : 0;
        dp[0][1] = (ch1[0] == ch2[1]) ? 1 : 0;
        dp[1][0] = (ch1[1] == ch2[0]) ? 1 : 0;

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (ch1[i] == ch2[j]) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[len1 - 1][len2 - 1];
    }

    public static void main(String[] args) {
        String string1 = "ABCD";
        String string2 = "EACB";
        System.out.println(longestCommonSubstring(string1, string2));
    }
}
