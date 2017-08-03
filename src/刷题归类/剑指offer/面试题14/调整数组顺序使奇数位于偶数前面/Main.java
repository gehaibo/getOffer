package 刷题归类.剑指offer.面试题14.调整数组顺序使奇数位于偶数前面;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghb on 2017/4/9.
 */
public class Main {
    /**
     * 调整数组顺序使奇数位于偶数前面!!!!!!!顺序打乱了
     * 对于一个数组，实现一个函数使得所有奇数位于数组的前半部分，偶数位于数组的后半部分。
     * 思路一：
     * 可以使用双指针的方式，一个指针指向数组的开始，一个指针指向数组的尾部，如果头部的数为偶数且尾部的数是奇数则交换，否则头部指针向后移动，尾部指针向前移动，直到两个指针相遇
     */
    public static void recordOddEven(int array[]) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            while (low < high && ((array[low] & 1) == 1))  low++;

            while (low < high && ((array[high] & 1) == 0)) high--;

            if (low < high) {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }

        }
    }


    public static void reOrderArray(int [] array){
        List<Integer> result=new ArrayList<>();
        if (array.length<=1) return;
        for (int i = 0; i < array.length; i++) {
            if ((array[i]&1)==1) result.add(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i]&1)==0) result.add(array[i]);
        }
        for (int i = 0; i < result.size(); i++) {
            array[i]=result.get(i);
        }
    }

    /**
     * 思路二：再创建一个数组，两次遍历原数组，第一次将奇数顺序存储，第二次将偶数顺序存储。
     * 顺序不乱
     */
    public void reOrderArray2(int[] array) {
        if (array == null || array.length == 0)
            return;
        int[] result = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1)
                result[j++] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                result[j++] = array[i];
        }
        if (result.length != array.length)
            throw new RuntimeException("Error result!");
        for (int i = 0; i < array.length && i < result.length; i++) {
            array[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7};
        //recordOddEven(a);
        reOrderArray(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }

    }
}
