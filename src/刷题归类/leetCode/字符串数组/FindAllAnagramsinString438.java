package 刷题归类.leetCode.字符串数组;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 字符串S和P，找出s中所有和p相等的索引，只是字母相等，顺序可以不相等
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */
public class FindAllAnagramsinString438 {
    /**
     * 滑动窗口
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return Collections.emptyList();

        int[] meno = new int[256];

        //p子串依次放入数组
        for (char c : p.toCharArray()) {
            meno[c]++;
        }

        //count控制窗口大小
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {

            if (meno[s.charAt(right++)]-- >= 1) count--;
            if (count == 0) res.add(left);
            if (right - left == p.length() && meno[s.charAt(left++)]++ >= 0) count++;
        }
        return res;


    }
}
