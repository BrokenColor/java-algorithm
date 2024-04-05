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

    /**
     * 计算在给定股票价格数组中能获得的最大利润。
     * 参数：
     *   prices - 一个整数数组，表示每天的股票价格。
     * 返回值：
     *   一个整数，表示在最后一天卖出时能获得的最大利润。
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][][] dp = new int[length][3][2];
        // 遍历每一天
        for (int i = 0; i < length; i++) {
            // 遍历可进行的交易次数（1次或2次）
            for (int k = 1; k <= 2; k++) {
                // 初始化第一天的状态
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = Integer.MIN_VALUE;
                    continue;
                }
                // 计算第i天卖出的利润
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                // 计算第i天买入的利润
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        // 返回最后一天的卖出利润
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

    /**
     * 计算给定股票价格数组中可能的最大利润。
     * 该函数采用动态规划的方法，其中 sell1 表示第1笔交易卖出的最大利润，sell2 表示第2笔交易卖出的最大利润，
     * buy1 表示第1笔交易买入的最大利润，buy2 表示第2笔交易买入的最大利润。
     *
     * @param prices 股票每天的价格数组。
     * @return 返回通过两次交易可能获得的最大利润。
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        // 遍历每一天的价格，更新买卖状态以获取最大利润
        for (int i = 0; i < n; i++) {
            // 更新第2笔卖出的利润
            sell2 = Math.max(sell2, buy2 + prices[i]);
            // 更新第2笔买入的利润，考虑卖出后重新买入的情况
            buy2 = Math.max(buy2, sell1 - prices[i]);
            // 更新第1笔卖出的利润
            sell1 = Math.max(sell1, buy1 + prices[i]);
            // 更新第1笔买入的利润，每天的最低价可以作为潜在的买入点
            buy1 = Math.max(buy1, -prices[i]);
        }
        // 返回第2笔交易卖出时的最大利润
        return sell2;
    }
}
