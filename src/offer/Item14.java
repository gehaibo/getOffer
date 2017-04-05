package offer;

import java.util.Arrays;

/**
 * Created by ghb on 2017/2/17.
 * 面试题14：调整数组顺序使奇数位于偶数前面
 题目大致为：
 对于一个数组，实现一个函数使得所有奇数位于数组的前半部分，偶数位于数组的后半部分。
 思路：
 可以使用双指针的方式，一个指针指向数组的开始，一个指针指向数组的尾部，如果头部的数为偶数且尾部的数是奇数则交换，否则头部指针向后移动，尾部指针向前移动，直到两个指针相遇
 */
public class Item14 {
    public static void recordOddEven(int array[]){
        int low = 0;
        int high = array.length - 1;
        while (low < high){
            if(array[low] % 2 == 0 && array[high] % 2 ==1){
                int temp ;
                temp = array[low];
                array[low] = array[high];
                array[high] = temp;

                low++;
                high--;
            }else if (array[low] % 2 == 1){
                low++;
            }else {
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        recordOddEven(a);
        System.out.println(Arrays.toString(a));
    }
}
