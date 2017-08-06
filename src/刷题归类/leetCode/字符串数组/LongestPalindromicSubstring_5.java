package 刷题归类.leetCode.字符串数组;

import java.util.HashSet;

/**
 * 基本思路是外层循环i从后往前扫，内层循环j从i当前字符扫到结尾处。
 * 过程中使用的历史信息是从i+1到n之间的任意子串是否是回文已经被记录下来，所以不用重新判断，只需要比较一下头尾字符即可。
 * 这种方法使用两层循环，时间复杂度是O(n^2)。而空间上因为需要记录任意子串是否为回文，需要O(n^2)的空间，
 */
public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        boolean[][] palin = new boolean[s.length()][s.length()];
        String res = "";
        int maxLen = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || palin[i + 1][j - 1])) {
                    palin[i][j] = true;
                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    /**
     * 那么对于找回文字串的问题，就要以每一个字符为中心，像两边扩散来寻找回文串，这个算法的时间复杂度是O(n*n)，可以通过OJ，就是要注意奇偶情况，由于回文串的长度可奇可偶，比如”bob”是奇数形式的回文，”noon”就是偶数形式的回文，两种形式的回文都要搜索
     */

    private int lo, maxLen;

    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (maxLen < end - start - 1) {
            lo = start + 1;
            maxLen = end - start - 1;
        }
    }

    //647. Palindromic Substrings
    int count = 0;

    public int countSubstrings(String s) {
        int len = s.length();
        if (len < 2) return count + 1;
        for (int i = 0; i < len - 1; i++) {
            extendPalindrome2(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome2(s, i, i + 1); //assume even length.
        }

        return count;

    }

    private void extendPalindrome2(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {//每找到一次加1
            count++;
            left--;
            right++;
        }
    }

    //LeetCode 516. Longest Palindromic Subsequence
    public int longestPalindromeSubseq(String s) {
        int size = s.length();
        int[][] dp = new int[size][size];
        for (int i = size - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < size; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][size - 1];
    }

    //反转数字判断
    public static boolean isPalindrome(int x) {

        if (x < 0) return false;
        if (x < 10) return true;
        if (x % 10 == 0) return false;
        //if (x % 10 == 0 && x != 0) return false;

        int rev = 0, tem = x;
        //求数字的逆序
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        if (tem == rev) {
            return true;
        }
        return false;
    }

    //125. Valid Palindrome
    //模拟两个指针，从两边向中间
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while (head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }

    // Leetcode 409. Longest Palindrome

    /**
     * 思路：偶数的一定能找到对称的，遇到重复的就抵消掉
     *
     * @param s
     * @return
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

    /**
     * 344. Reverse String
     */
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }

    public static void main(String[] args) {
        int a = 1;
        System.out.println(isPalindrome(a));
    }
}
