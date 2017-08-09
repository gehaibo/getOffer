package 刷题归类.leetCode.字符串数组;

/**
 * 字符串元音字母反转
 */
public class ReverseVowels345 {
    public String reverseVowels(String s) {
        char[] words = s.toCharArray();
        //技巧
        String vowels = "aeiouAEIOU";

        int l = 0;
        int r = words.length - 1;
        while (l < r) {
            while (l < r && !vowels.contains(words[l] + "")) l++;
            while (l < r && !vowels.contains(words[r] + "")) r--;

            //交换两个元音字母
            char temp = words[l];
            words[l] = words[r];
            words[r] = temp;

            l++;
            r--;
        }
        return new String(words);
    }
}
