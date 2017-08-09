package 刷题归类.leetCode.字符串数组;

/**
 * 非负整数a1....an  表示垂直于x轴的木板长度，求两块之间和x走构成的能容纳最大容量水
 * <p>
 * 影响容器的因素是最短的边决定的
 * 容器两条边中取最短的那条边为影响容器容积的高，所以说，我们先假设left和right分别在最左边最右边，
 * 要想求得容器容积的最大值，需要考虑改变最短边的高度，如果左边短就让left++，如果右边短就让right–，直到直到一个area容积最大的值返回
 */
public class ContainerMostWater11 {

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r) {
            max = Math.max(max, Math.min(height[r], height[l]) * (r - l));
            if (height[l] < height[r]) l++;
            else r--;

        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, 1};
        System.out.println(maxArea(a));
    }
}
