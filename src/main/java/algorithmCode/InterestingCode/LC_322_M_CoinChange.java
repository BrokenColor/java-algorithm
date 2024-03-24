package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 322 零钱兑换
 *
 * @author bc
 * @date 2021/9/23 8:07 下午
 */
public class LC_322_M_CoinChange {
    //输入：coins = [1, 2, 5], amount = 11
    //输出：3
    //解释：11 = 5 + 5 + 1
    private static int[] memo;

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        //用来记录已经计算过的子问题结果
        memo = new int[amount + 1];
        // dp 数组全都初始化为特殊值
        Arrays.fill(memo, -6);
        System.out.println(dp(coins, amount));
    }

    public static int dp(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        //判断是否计算过，如果计算过直接使用
        if (memo[amount] != -6) return memo[amount];

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            //遍历处理子问题
            int cost = dp(coins, amount - coins[i]);
            if (cost == -1) continue;
            /**
             * 当前问题与之前结果比较，取花费小的
             * 当前问题：即当前coins[i]币值(1) + 最优子问题值花费(cost)；
             * 之前结果：即其他币值算出的最优花费
             */
            res = Math.min(res, 1 + cost);
        }
        //把计算结果存入到数组中，
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
