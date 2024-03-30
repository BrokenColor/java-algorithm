package algorithmCode.InterestingCode;

/**
 * 121.买卖股票的最佳时机
 *
 * @author bc
 * @date 2022/12/25 20:50
 */
public class LC_121_S_MaxProfit {
    public static void main(String[] args) {
        LC_121_S_MaxProfit solution = new LC_121_S_MaxProfit();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /**
     * 计算在给定股票价格数组中能够实现的最大利润。
     *
     * @param prices 股票每天的价格数组。
     * @return 返回能够实现的最大利润。
     */
    public int maxProfit(int[] prices) {
        // 初始化卖出利润为0，买入利润为最小整数，确保第一次买入时是最低价。
        int sell = 0, buy = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // 根据当前价格，更新卖出利润，选择不卖出或卖出当前股票的利润中的最大值。
            sell = Math.max(sell, buy + prices[i]);
            // 根据当前价格，更新买入利润，选择不买入或买入当前股票的利润中的最大值。
            buy = Math.max(buy, -prices[i]);
        }
        // 返回最后的卖出利润，即为整个过程中的最大利润。
        return sell;
    }

    /**
     * 暴力
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int length = prices.length;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int length = prices.length;
        int maxProfit = Integer.MIN_VALUE;//最大收益
        int minPrice = prices[0];//局部最小值
        for (int i = 1; i < length; i++) {
            //判断是否比minPrice小，
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                //上一次最大收益跟这次收益比较
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
