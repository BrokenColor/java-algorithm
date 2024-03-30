package algorithmCode.InterestingCode;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author bc
 * @date 2021/12/17 10:24
 */
public class LC_122_M_MaxProfit {
    public static void main(String[] args) {
        LC_122_M_MaxProfit solution = new LC_122_M_MaxProfit();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /**
     * 计算在给定股票价格数组中可实现的最大利润。
     *
     * @param prices 股票每天的价格数组。
     * @return 可以通过多次买卖股票实现的最大利润。
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0; // 初始化最大利润为0

        // 遍历股票价格数组，计算每一天卖出时的最大利润
        for (int i = 0; i < prices.length - 1; i++) {
            // 如果当前价格小于下一个价格，则计算利润并累加到最大利润中
            if (prices[i] < prices[i + 1]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit; // 返回最大利润
    }

    /**
     * 递归处理股票买卖问题
     *
     * @param prices 股票每天的价格数组
     * @return 返回最后一天卖出时的最大利润
     */
    public int maxProfit1(int[] prices) {
        // 初始化买卖状态，buy为最小可能的买入价，sell为0（即尚未买入）
        int sell = 0, buy = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // 保存上一轮的sell值，用于计算新的buy值
            int preSell = sell;
            // 计算当前天数卖出的最大利润，选择继续持有或卖出
            sell = Math.max(sell, buy + prices[i]);
            // 计算当前天数买入的最大利润，选择继续持有或买入
            buy = Math.max(buy, preSell - prices[i]);
        }
        // 返回最后一天卖出时的最大利润
        return sell;
    }

}
