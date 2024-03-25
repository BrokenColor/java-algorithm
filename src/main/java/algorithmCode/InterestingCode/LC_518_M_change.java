package algorithmCode.InterestingCode;

/**
 * 518.零钱兑换 II
 * @Author bc
 * @Date 2024/3/25 23:17
 * @Description: 动态规划
 */
public class LC_518_M_change {

    public static void main(String[] args) {
        LC_518_M_change solution = new LC_518_M_change();
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
        System.out.println(solution.change(3, new int[]{2}));
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
