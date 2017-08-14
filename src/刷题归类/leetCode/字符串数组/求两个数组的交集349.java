package 刷题归类.leetCode.字符串数组;

import java.util.HashSet;

/**
 * 返回不重复
 * 使用哈希Set存入第一个数组的值
 * 遍历第二个数组，如果第二个的数在Set中出现，那么就是交集（与此同时，因为只能返回一个值，所以出现后还需要从Set中删除哦）
 */
public class 求两个数组的交集349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        int len1 = nums1.length, len2 = nums2.length;
        for (int i = 0; i < len1; i++) set.add(nums1[i]);
        for (int j = 0; j < len2; j++) {
            if (set.contains(nums2[j])) {
                res.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }

        int[] arr = new int[res.size()];
        int i = 0;
        for (Integer num : res) {
            arr[i++] = num;
        }
        return arr;
    }
}
