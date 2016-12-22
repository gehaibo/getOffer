package offer;

/**
 * 面试题一：二维数组查找
 * Created by ghb on 2016/12/22.
 */
public class content1 {
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
