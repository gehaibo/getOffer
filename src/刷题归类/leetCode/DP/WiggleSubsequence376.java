package 刷题归类.leetCode.DP;

/**
 * 如果连续数字之间的差异在正和负之间严格交替，则数字序列称为摆动序列。
 * 求正负摆动最长的
 */
public class WiggleSubsequence376 {

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;

        if (len < 2)
            return len;

        int[] up = new int[len];
        int[] down = new int[len];

        up[0] = 1;
        down[0] = 1;

        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {//上升，等于前一个下降+1
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }

        return Math.max(down[len - 1], up[len - 1]);
    }
}
