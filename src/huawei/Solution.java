package huawei;

/**
 * Created by ghb on 2017/3/23.
 */
public class Solution {
    /**
     * 交换数组里n和0的位置
     *
     * @param array 数组
     * @param len   数组长度
     * @param n     和0交换的数
     */
    // 不要修改以下函数内容
    public void swapWithZero(int[] array, int len, int n) {
        // interviewCollection.Main.SwapWithZero(array, len, n);
    }
    // 不要修改以上函数内容


    /**
     * 通过调用swapWithZero方法来排
     *
     * @param array 存储有[0,n)的数组
     * @param len   数组长度
     */
    public void sort(int[] array, int len) {
        if (len <= 1) {
            return;
        }
        for (int i = len - 1; i > 0; --i) {
            swapWithZero(array, len, array[i]);
            int curMax = array[i];
            for (int j = i; j >= 0; --j) {
                if (array[j] > curMax) {
                    curMax = array[j];
                }
            }
            swapWithZero(array, len, curMax);
        }
    }

}
