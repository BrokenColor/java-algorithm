package algorithmCode.InterestingCode;

/**
 * 123.买卖股票的最佳时机 III
 *
 * @author bc
 * @date 2023/1/6 20:54
 */
public class LC_123_H_MaxProfit {

    public static void main(String[] args) {
        LC_123_H_MaxProfit solution = new LC_123_H_MaxProfit();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int[] prices1 = {1,2,3,4,5};
        System.out.println(solution.maxProfit2(prices1));
    }

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][][] dp = new int[length][3][2];
        for (int i = 0; i < length; i++) {
            for (int k = 1; k <= 2; k++) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = Integer.MIN_VALUE;
                    continue;
                }
                //第i天卖出的利润
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                //第i天买入的利润
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        //最后一天的卖出的利润
        return dp[length - 1][2][0];
    }

    public int maxProfit1(int[] prices) {
        int length = prices.length, max_k = 2;
        int[][][] dp = new int[length][max_k + 1][2];
        for (int i = 0; i < length; i++) {
            for (int k = max_k; k >= 1; k--) {
                //base case
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                //第i天卖出的利润 max(昨天的卖出利润,昨天的买入利润+股票价格)
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);

                //第i天买入的利润 max(昨天的买入利润,昨天的卖出利润-股票价格)
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        //最后一天的卖出的利润
        return dp[length - 1][max_k][0];
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            //第2笔卖出的利润
            sell2 = Math.max(sell2, buy2 + prices[i]);
            //第2笔买入的利润
            buy2 = Math.max(buy2, sell1 - prices[i]);
            //第1笔卖出的利润
            sell1 = Math.max(sell1, buy1 + prices[i]);
            //第1笔买入的利润
            buy1 = Math.max(buy1, -prices[i]);
        }
        return sell2;
    }
}
