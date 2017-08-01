package 上机考试.实习.携程;

/**
 * Created by ghb on 2017/4/11.
 */
public class Main2 {

    public int calculateMax(int[] stockPrices, int k) {
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;

        int sell1 = 0, sell2 = 0;

        for (int i = 0; i < stockPrices.length; i = i + k) {

            buy1 = Math.max(-stockPrices[i], buy1);

            sell1 = Math.max(stockPrices[i] + buy1, sell1);

            buy2 = Math.max(sell1 - stockPrices[i], buy2);

            sell2 = Math.max(buy2 + stockPrices[i], sell2);
        }

        return sell2;
    }
}
