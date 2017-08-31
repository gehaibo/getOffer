package 刷题归类.剑指offer;

import java.util.HashMap;

/**
 * 题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出"b"。
 * <p>
 * 用HashMap，遍历两次字符串数组，第一遍遍历更新map，第二次遍历查询map；
 * 当value == 1，则输出。
 */
public class 字符串35第一个只出现一次的字符 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null) return -1;
        char[] c = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < c.length; i++) {
            if (!map.containsKey(c[i])) {
                map.put(c[i], 1);
            } else {
                map.put(c[i], map.get(c[i]) + 1);
            }
        }

        for (int i = 0; i < c.length; i++) {
            if (map.get(c[i]) == 1)
                return i;
        }

        return -1;
    }
}
