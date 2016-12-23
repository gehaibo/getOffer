package offer;

/**
 * 面试题3：二维数组查找
 *  一个二维数组，每一行按照从左到右递增，每一列按照从上到下递增，查找数组中是否存在某个数。如数组：
 * 1  2  8    9
 * 2  4  9   12
 * 4  7  10  13
 * 6  8  11  15
 * 思路：从右上角或左下角就可以每一步排除一列或一行
 * Created by ghb on 2016/12/22.
 */
public class Item3 {
    /**
     * 二维数组查找
     * @param array 已知的数组
     * @param num 待查找的数
     * @return
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

    public static void main(String[] args) {

        int a[][] = {{ 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 }};
        System.out.println(find(a,7));
    }
}
