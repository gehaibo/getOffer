package 刷题归类.剑指offer;

import java.util.HashMap;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class 数组51数组中重复的数字 {
    /**
     * 用哈希，但是空间复杂度为O（n）
     */
    //duplication长度为1，duplication[0] 返回结果
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean res = false;
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], 1);
            } else {
                map.put(numbers[i], map.get(numbers[i]) + 1);
                if (map.get(numbers[i]) == 2) {
                    res = true;
                    duplication[0] = numbers[i];
                    break;
                }
            }
        }
        return res;
    }
    /**
     * 利用特殊
     */

}
