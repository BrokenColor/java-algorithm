package algorithmCode.InterestingCode;

/**
 * 188.买卖股票的最佳时机 IV
 *
 * @author bc
 * @date 2023/1/6 21:49
 */
public class LC_188_H_MaxProfit {
    public static void main(String[] args) {
        int k = 2;
        int[] prices = {2, 4, 1};
        LC_188_H_MaxProfit slotion = new LC_188_H_MaxProfit();
        System.out.println(slotion.maxProfit(k, prices));
    }

    /**
     * 计算在给定股票价格数组中能获得的最大利润。
     * 其中 k 代表进行交易的最大次数，prices 是股票每天的价格数组。
     *
     * @param k 最大交易次数
     * @param prices 股票价格数组
     * @return 能获得的最大利润
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length; // 数组长度
        int[][][] dp = new int[n][k + 1][2]; // 动态规划数组，dp[i][j][0] 表示第 i 天时不持有股票的最大利润，dp[i][j][1] 表示第 i 天时持有股票的最大利润

        // 初始化第一天的状态
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0; // 第一天不持有股票时利润为 0
                    dp[i][j][1] = -prices[i]; // 第一天持有股票时利润为负数（相当于花费了 prices[i] 买股票）
                    continue;
                }
                // 计算第 i 天时不持有股票的最大利润
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                // 计算第 i 天时持有股票的最大利润
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0]; // 返回最后一天不持有股票时的最大利润
    }
}
