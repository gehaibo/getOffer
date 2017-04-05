package bag;

/**
 * 01背包问题
 * @author honest
 *
 */
public class DynamicKnapSack {
    private int[] v;//v[i]表示第i个物品的价值
    private int[] w;//w[i]表示第i个物品的重量
    private int[][] c;//其中i的最大值为物品的数量，而w表示最大的重量限制
    private int weight;

    public DynamicKnapSack(int length, int weight, int[] vin, int[] win) {
        v = new int[length + 1];
        w = new int[length + 1];
        c = new int[length + 1][weight + 1];
        this.weight = weight;
        for(int i = 0; i < length + 1; i++) {
            v[i] = vin[i];
            w[i] = win[i];
        }
    }

    public void solve() {
        for(int i = 1; i < v.length; i++) {
            for(int k = 1; k <= weight; k++) {
                if(w[i] <= k) {
                    if(v[i] + c[i - 1][k - w[i]] > c[i - 1][k])
                        c[i][k] = v[i] + c[i - 1][k - w[i]];
                    else
                        c[i][k] = c[i - 1][k];
                } else
                    c[i][k] = c[i - 1][k];
            }
        }
    }

//    public void printResult() {
//        for(int i = 0; i < v. length; i++) {
//            for(int j = 0; j <= weight; j++)
//                System.out.print(c[i][j] + " ");
//            System.out.println();
//        }
//    }

    public static void main(String[] args) {
        int[] v = { };
        int[] w = { 10, 20, 30};
        int weight = 50;
        DynamicKnapSack knapsack = new DynamicKnapSack(2, weight, v, w);
        knapsack.solve();
        System.out.println(knapsack.c[v.length-1][weight]);
    }
}