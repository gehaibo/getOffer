package 刷题归类.leetCode.DP.背包问题;

/**
 * 给定几个固定的面值，可以无限使用。一个目标数，要求用最少的硬币兑换这个target
 *
 * dp[i] = min {dp[i - a], dp[i - b], dp[i - c] ...... }
 */
public class coinChange322 {

    public static int coinChange(int[] coins, int money) {
        if (coins == null || coins.length == 0 || money <= 0)
            return 0;
        //保存面值为 i 的纸币找零所需的最小硬币数
        int[] minNumber = new int[money + 1];
        for (int i = 1; i <= money; i++) {

            minNumber[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && minNumber[i - coins[j]] != Integer.MAX_VALUE)
                    minNumber[i] = Math.min(minNumber[i], 1 + minNumber[i - coins[j]]);
            }
        }

        return minNumber[money] == Integer.MAX_VALUE ? minNumber[money] : -1;
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = 0x7fff_fffe;
        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        return dp[amount] == 0x7fff_fffe ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));

    }
}
