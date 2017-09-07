package 刷题归类.剑指offer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class 数组41和为s的两个数字_和为连续正数序列 {
    public int FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (sum < 1) {
            return 0;
        }
        int small = 1;
        int big = 2;
        while (small != (1 + sum) / 2) {
            int curSum = sumList(small, big);
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                lists.add(list);
                small++;
                big++;
            } else if (curSum < sum) {
                big++;
            } else {
                small++;
            }
        }
        return lists.size();
    }

    public int sumList(int head, int leap) {        //计算当前序列的和
        int sum = head;
        for (int i = head + 1; i <= leap; i++) {
            sum += i;
        }
        return sum;
    }
}
