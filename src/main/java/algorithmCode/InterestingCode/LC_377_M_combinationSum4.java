package algorithmCode.InterestingCode;

/**
 * 377. 组合总和 Ⅳ
 *
 * @Author bc
 * @Date 2024/4/22 23:56
 * @Description: 动态规划
 */
public class LC_377_M_combinationSum4 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        LC_377_M_combinationSum4 solution = new LC_377_M_combinationSum4();
        System.out.println(solution.combinationSum4(nums, target));
    }

    /**
     * 计算组合总数。给定一个数组 nums，它由 1 到 9 的整数组成，目标是找到所有可能的数字组合，这些组合的和等于目标数 target。
     *
     * @param nums   给定的数组，包含 1 到 9 的整数。
     * @param target 目标和。
     * @return 返回组合总数。
     */
    public int combinationSum4(int[] nums, int target) {
        // 创建一个数组 dp，用于存储到当前和值为止的组合总数。
        int[] dp = new int[target + 1];
        // 初始化 dp[0] 为 1，表示和为 0 的组合只有一种：不选择任何数字。
        dp[0] = 1;
        // 遍历从 1 到目标和值的所有可能和值。
        for (int i = 0; i <= target; i++) {
            // 遍历数组中的每个数字。
            for (int num : nums) {
                // 如果当前和值大于等于当前数字，则将 dp[i] 增加 dp[i - num]，表示选择当前数字后的组合数量。
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        // 返回目标和值的组合总数。
        return dp[target];
    }
}
