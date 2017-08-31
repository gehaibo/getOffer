package 刷题归类.leetCode.DP;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle120 {
    /**
     * MP(i,j)=min{MP(i+1,j),MP(i+1,j+1)}+triangle[i][j]
     * 从位置（i,j）达到下一行的最小路径和为MP(i,j)
     * 自底向上
     * 为节省空间，用一维数组存储后面表示上一次要更新的
     * f（i）=v(i)+min{f(i)，f(i+1)}
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[] memo = new int[length + 1];
        for (int i = length - 1; i >= 0; i--) {//自底向上
            for (int j = 0; j < triangle.get(i).size(); j++) {//每层遍历
                memo[j] = triangle.get(i).get(j) + Math.min(memo[j], memo[j + 1]);
            }
        }
        return memo[0];
    }
}
