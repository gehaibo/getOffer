package 算法分类.剑指offer.面试题31.连续子数组的最大和;

/**
 * 分析数组规律法：对于一个数A，若A的左边累计数非负，那么加上A能使值不小于A，则认为累计值
 *				 对当前子数组整体和是有贡献的；如果前几项累计值为负数，则认为有害于当前子
 *				 数组总体和，total记录当前和值，若total大于maxSum，则maxSum=total.
 */
public class Main {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int total = array[0];
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (total >= 0) {
                total += array[i];
            }else {
                total = array[i];
            }
            if (total > maxSum)
                maxSum = total;
        }
        return maxSum;
    }
}
