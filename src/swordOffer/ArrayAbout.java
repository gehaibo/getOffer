package swordOffer;

/**
 * Created by ghb on 2017/4/5.
 */
public class ArrayAbout {


    /**
     * offer-3：二维数组查找
     *  一个二维数组，每一行按照从左到右递增，每一列按照从上到下递增，查找数组中是否存在某个数。如数组：
     * 1  2  8    9
     * 2  4  9   12
     * 4  7  10  13
     * 6  8  11  15
     * 思路：从右上角或左下角就可以每一步排除一列或一行
     * Created by ghb on 2016/12/22.
     */
    public static boolean find(int[][] array, int num) {
        boolean result = false;
        int rows = array.length;//行数
        int columns = array[0].length;//列数
        int row = 0;
        int column = columns - 1;//按数组显示
        while (row < rows && column >= 0) {
            if (array[row][column] == num) {
                result = true;
                break;
            } else if (array[row][column] < num){
                row++;
            }else {
                column--;
            }
        }
        return result;
    }

    /**
     * offer-14：调整数组顺序使奇数位于偶数前面
     对于一个数组，实现一个函数使得所有奇数位于数组的前半部分，偶数位于数组的后半部分。
     思路：
     可以使用双指针的方式，一个指针指向数组的开始，一个指针指向数组的尾部，如果头部的数为偶数且尾部的数是奇数则交换，否则头部指针向后移动，尾部指针向前移动，直到两个指针相遇
     */
    public static void recordOddEven(int array[]) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            if (array[low] % 2 == 0 && array[high] % 2 == 1) {
                int temp;
                temp = array[low];
                array[low] = array[high];
                array[high] = temp;

                low++;
                high--;
            } else if (array[low] % 2 == 1) {
                low++;
            } else {
                high--;
            }
        }
    }


    /**
     * offer-29:数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组｛1，2，3，2，2，2，5，4，2｝。
     * 由于数字2在数组中出现5次，超过数组长度的一半，因此输出2.
     */
    static int moreThanHalfNum(int[] number){
        if (number.length ==0)
            return -1;
        int result = number[0];//记录数字出现的次数
        int times = 1;
        for (int i = 1 ; i<number.length;i++){
            if (times ==0){
                result = number[i];
                times = 1;
            }else if (number[i] == result){
                times++;
            }else{
                times--;
            }
        }

        return result;
    }

    public static void main(StringAbout[] args) {

        /**
         * offer-3：二维数组查找
         *  一个二维数组，每一行按照从左到右递增，每一列按照从上到下递增，查找数组中是否存在某个数
         */
        int a[][] = {{ 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 }};
        System.out.println(find(a,7));

        /**
         * offer-29:数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
         */
        int[] number = {1,2,3,4,5,2,2,2,2,2,2};
        System.out.println(moreThanHalfNum(number));
    }
}
