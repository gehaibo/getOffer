package leetCode.Word_break;

import java.util.List;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s ="leetcode",
 * dict =["leet", "code"].
 * Return true because"leetcode"can be segmented as"leet code".
 */
public class Main {
    /**
     * 思路：
     * 状态转移方程：
     * 状态数组：f[s.length()+1]，f[i]代表：f[0,i-1] 可被字典中的单词分割
     * f(i) = f(j) && string[i,j]; 0 <= j < i;//j以前可以分割，且后面部分i到j在dic中能找到
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }

        }
        return f[s.length()];
    }

}
