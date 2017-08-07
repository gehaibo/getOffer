package 刷题归类.leetCode.字符串数组.回文;

/**
 * Created by Jackson on 2017/8/7.
 */
public class ValidPalindrome125 {
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

}
