package leetCode;

/**
 * Created by Jackson on 2017/5/8.
 */
public class coinChange_322 {

    public static int search(int indx, int amount, int[] coins) {
        if (amount <= 0) return 0;

        if (amount < 0) return -1;

        if (indx >= coins.length) return -1;

        return Math.min(search(indx, amount - coins[indx], coins)+1, search(indx + 1, amount, coins));

    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = 0x7fff_ffff;
        //Arrays.fill(dp,0x7fff_fffe);
        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        return dp[amount] == 0x7fff_ffff ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins={1,2,5};
        System.out.println(coinChange(coins,11));
    }
}
