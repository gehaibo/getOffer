package 刷题归类.leetCode.字符串数组;

/**
 * 在一个字符串中寻找没有重复的字母的最长子串
 * <p>
 * 两个指针，r++，没有重复一直加，重复，l++，直到没有重复
 */
public class LongestSubstringWithouRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, length = s.length();
        char[] chars= s.toCharArray();
        int[] fre=new int[256];
        int max = 0;
        while (r < length) {
            if (fre[chars[r]]==0) {//没有重复
                fre[chars[r++]]++;
            } else {
                max=Math.max(max,r-l+1);
            }
        }
        return max;
    }
}
