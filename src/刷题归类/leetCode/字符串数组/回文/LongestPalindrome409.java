package 刷题归类.leetCode.字符串数组.回文;

import java.util.HashSet;

/**
 * 只有大小写，判断能构成的最大回文串长度
 * Input:
 * "  abccccdd"
 * Output:
 * 7   //be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome409 {
    // Leetcode 409. Longest Palindrome

    /**
     * 思路：偶数的一定能找到对称的，遇到重复的就抵消掉
     * set存储，遇到相同的就抵消掉，如果set为空，直接为2倍，
     * 不为空，2倍加1
     *
     */
    public int longestPalindrome22(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> sets = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (sets.contains(s.charAt(i))) {
                sets.remove(s.charAt(i));
                count++;
            } else {
                sets.add(s.charAt(i));
            }
        }

        if (!sets.isEmpty()) return count * 2 + 1;
        return count * 2;
    }

}
