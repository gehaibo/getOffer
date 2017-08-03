package 刷题归类.剑指offer.面试题03.二维数组中的查找;

/**
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * *  一个二维数组，每一行按照从左到右递增，每一列按照从上到下递增，查找数组中是否存在某个数。如数组：
 * 1  2  8    9
 * 2  4  9   12
 * 4  7  10  13
 * 6  8  11  15
 * 思路：从可以从左下角或右上角开始搜索，就可以每一步排除一列或一行
 * 当从右上角开始搜索时，target > array[row][col]则向下移，即row++;
 * target < array[row][col]则向左移，即col--
 *
 * PS:二维数组a[][]的行长度为a.length,列长度为a[0].length。
 */
public class Main {
    public static boolean find(int[][] array, int num) {
        int row = 0;//行号
        int col = array[0].length - 1;//列号

        while(row <= array.length - 1 && col >= 0){
            if(num < array[row][col]){
                col --;
            }else if(num > array[row][col]){
                row ++;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a[][] = {{ 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 }};
        System.out.println(find(a,7));
    }
}
