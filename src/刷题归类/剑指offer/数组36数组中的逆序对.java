package 刷题归类.剑指offer;

/**
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对总数 P。并将 P 对1000000007取模的结果
 * 输出。 即输出P%1000000007。
 * 运用归并排序思想，
 * 1.先把数组分割成子数组，统计出子数组内部的逆序对数目并对子数组排序。
 * 2.统计两个相邻子数组之间逆序对的数目，并排序。
 * <p>
 * 在归并排序中merge的时候记录前面大于后面
 * http://blog.csdn.net/wtyvhreal/article/details/45664949
 */
public class 数组36数组中的逆序对 {

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) return -1;
        return InversePairs(array, 0, array.length - 1);
    }

    private int InversePairs(int[] array, int l, int r) {
        if (l >= r) return 0;
        int mid = l + (r - l) / 2;
        int lCount = InversePairs(array, l, mid);
        int rCount = InversePairs(array, mid + 1, r);
        int res = merge(array, l, mid, r) + lCount + rCount;
        return res % 1000000007;
    }

    //和归并有点区别，从后往前，l的值大于r的值，就++
    private int merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int pos = right - left;
        int l = mid, r = right;
        int count = 0;

        while (l >= left && r >= mid + 1) {
            if (array[l] > array[r]) {
                temp[pos--] = array[l--];
                count += r - mid;//比最大的都打，一定比最小的也大
                if (count > 1000000007)
                    count %= 1000000007;
            } else {
                temp[pos--] = array[r--];
            }
        }
        while (l >= left)
            temp[pos--] = array[l--];
        while (r >= mid)
            temp[pos--] = array[r--];

        for (int i = 0; i < temp.length; i++) {
            array[left++] = temp[i];
        }
        return count;
    }
}
