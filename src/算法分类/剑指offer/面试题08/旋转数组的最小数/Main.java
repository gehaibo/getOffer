package 算法分类.剑指offer.面试题08.旋转数组的最小数;

/**
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *		 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *		 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *		 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 思路一：顺序遍历数组，因为数组排好序从小到大,遇到array[i+1]比i小，则array[i+1]为最小值。
 * 思路二：使用二分查找，
 *
 */

public class Main {
    //思路一
    public int minNumberInRotateArray(int [] array) {
        if (array.length==0) return 0;
        if (array.length==1) return array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i+1]<array[i])
                return array[i+1];
        }
        return array[0];//循环完了都没出现下降现象，所以是非递减排序的数组，第一个元素最小。
    }
    //思路二
}
