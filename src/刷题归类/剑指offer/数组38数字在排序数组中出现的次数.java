package 刷题归类.剑指offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 改进思路：使用二分查找分别找到第一个 K 和最后一个 K。
 */
public class 数组38数字在排序数组中出现的次数 {
    int getFirst(int[] array, int k) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (array[mid] == k) {
                if (mid == 0 || array[mid - 1] != k)
                    return mid;
                else
                    r = mid - 1;
            } else if (array[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    int getLast(int[] array, int k) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (array[mid] == k) {
                if (mid == array.length - 1 || array[mid + 1] != k)
                    return mid;
                else
                    l = mid + 1;
            } else if (array[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        int firstK = getFirst(array, k);
        int lastK = getLast(array, k);
        if (firstK == -1 || lastK == -1)
            return 0;
        return lastK - firstK + 1;
    }

}
