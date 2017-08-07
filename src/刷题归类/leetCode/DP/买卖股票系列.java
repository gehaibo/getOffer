package 刷题归类.leetCode.DP;

/**
 * Created by Jackson on 2017/8/6.
 * https://www.zybuluo.com/natsumi/note/511197
 */
public class 买卖股票系列 {
    //给一个数组prices[]，prices[i]代表股票在第i天的售价，求出只做一次交易(一次买入和卖出)能得到的最大收益。
    //121. Best Time to Buy and Sell Stock
    /**
     * 相似题[Maximum Subarray]，本题是找两个点使得end-start最大，[Maximum Subarray]是找一个区间使得区间内值的和最大
     * 想求y-x的最大值，则让y尽可能大，让x尽可能小
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        //一个记录买入最小，一个记录价值最大
        int min = prices[0];
        int profit = 0;

        // 第i天的价格可以看作是买入价也可以看作是卖出价
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < min) {// 找到更低的买入价
                min = prices[i];
            } else {// 当天的价格不低于买入价,适合买出
                if (prices[i] - min > profit) {// 如果当天买出的价格比之前卖出的价格高
                    profit = prices[i] - min;
                }
            }
        }
        return profit;
    }

    /**
     * Best Time to Buy and Sell Stock II 买股票的最佳时间之二,无限次买入和买出
     * 贪婪算法，只要第二天比第一天大，就可以进行一次操作，赚钱
     */




    /**
     * Best Time to Buy and Sell Stock III 买股票的最佳时间之三,最多两次买入买出
     * dp
     * 动态规划法。以第i天为分界线，计算第i天之前进行一次交易的最大收益preProfit[i]，和第i天之后进行一次交易的最大收益postProfit[i]，
     * 最后遍历一遍，max{preProfit[i] + postProfit[i]} (0≤i≤n-1)就是最大收益
     * 第i天之前和第i天之后进行一次的最大收益求法同Best Time to Buy and Sell Stock I。
     */
    public int maxProfit3(int[] prices) {
        if (prices.length < 2) return 0;
        int n = prices.length;
        int[] preProfit = new int[n];
        int[] postProfit = new int[n];
        int curMin = prices[0];
        for (int i = 1; i < n; i++) {
            curMin = Math.min(curMin, prices[i]);
            preProfit[i] = Math.max(preProfit[i - 1], prices[i] - curMin);
        }
        int curMax = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            curMax = Math.max(curMax, prices[i]);
            postProfit[i] = Math.max(postProfit[i + 1], curMax - prices[i]);
        }
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, preProfit[i] + postProfit[i]);
        }
        return  maxProfit;
    }

    /**
     * Best Time to Buy and Sell Stock III 买股票的最佳时间之三,最多交易k次
     * dp
     * 动态规划法。以第i天为分界线，计算第i天之前进行一次交易的最大收益preProfit[i]，和第i天之后进行一次交易的最大收益postProfit[i]，
     * 最后遍历一遍，max{preProfit[i] + postProfit[i]} (0≤i≤n-1)就是最大收益
     * 第i天之前和第i天之后进行一次的最大收益求法同Best Time to Buy and Sell Stock I。
     */


    /**
     * 309.Best Time to Buy and Sell Stock with Cooldown
     */
}
