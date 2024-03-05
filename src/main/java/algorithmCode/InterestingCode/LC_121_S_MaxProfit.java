package algorithmCode.InterestingCode;

/**
 * 121.买卖股票的最佳时机
 *
 * @author bc
 * @date 2022/12/25 20:50
 */
public class LC_121_S_MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        LC_121_S_MaxProfit solution = new LC_121_S_MaxProfit();
//        System.out.println(solution.maxProfit(prices));
//        System.out.println(solution.maxProfit1(prices));
        System.out.println(solution.maxProfit2(prices));
    }

    public int maxProfit(int[] prices) {
        int sell = 0, buy = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            //卖出的利润=  max（不操作的利润，卖出股票的利润）
            sell = Math.max(sell, buy + prices[i]);
            //买入的利润=  max（不操作的利润，买入股票的利润）
            buy = Math.max(buy, -prices[i]);
        }
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
