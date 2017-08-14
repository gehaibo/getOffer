package 刷题归类.leetCode.字符串数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 此题使用map存储1中每个相等数字次数
 * 遍历2依次和1比较，若存在且>0，--
 * 若存在=0，下一个
 */
public class 求两个数组的交集II350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int len1 = nums1.length, len2 = nums2.length;
        for (int i = 0; i < len1; i++) {
            if (map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i]) + 1);
            else map.put(nums1[i], 1);
        }

        for (int i = 0; i < len2; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                res.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int len3 = res.size();
        int[] r = new int[len3];
        for (int i = 0; i < len3; i++) {
            r[i] = res.get(i);
        }

        return r;
    }
}
