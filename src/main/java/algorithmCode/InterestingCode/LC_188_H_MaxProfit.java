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

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}
