package 算法分类.leetCode.DP;

/**
 * Created by Jackson on 2017/5/8.
 */
public class coinChange_322 {

    public static int coinChange(int[] coins, int money) {
        if (coins == null || coins.length == 0 || money <= 0)
            return 0;
        //保存面值为 i 的纸币找零所需的最小硬币数
        int[] minNumber = new int[money + 1];
        for (int i = 1; i <= money; i++) {
            minNumber[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && minNumber[i - coins[j]] != Integer.MAX_VALUE)
                    minNumber[i] = Integer.min(minNumber[i], 1 + minNumber[i - coins[j]]);
            }
        }
        if (minNumber[money] == Integer.MAX_VALUE )
            return -1;
        else
            return minNumber[money];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(coinChange(coins, 27));

    }
}
