package algorithmCode.InterestingCode;

/**
 * 309.最佳买卖股票时机含冷冻期
 *
 * @author bc
 * @date 2022/12/25 22:24
 */
public class LC_309_M_MaxProfit {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        LC_309_M_MaxProfit solution = new LC_309_M_MaxProfit();
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int sell = 0, pre_sell = 0, buy = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int temp = sell;
            //卖出利润 = max （不操作利润，买入利润+股票）
            sell = Math.max(sell, buy + prices[i]);
            //买入利润 = max( 不操作，前一天利润-股票)
            buy = Math.max(buy, pre_sell - prices[i]);
            //记录前一天的利润
            pre_sell = temp;
        }
        return sell;
    }
}
