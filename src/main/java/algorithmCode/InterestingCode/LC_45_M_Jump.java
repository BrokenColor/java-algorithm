package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 45.跳跃游戏 II
 *
 * @Author bc
 * @Date 2023/5/15 22:32
 * @Description: TODO
 */
public class LC_45_M_Jump {

    public static void main(String[] args) {
        int[] nums = {2, 1};
        LC_45_M_Jump solution = new LC_45_M_Jump();
        System.out.println(solution.jump(nums));
        System.out.println(solution.jump1(nums));
    }

    public int jump(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < length; i++) {
            int temp = i + nums[i];
            if (temp > length - 1) {
                temp = length - 1;
            }
            for (int j = 0; j <= temp; j++) {
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }

        }
        return dp[length - 1];
    }

    public int jump1(int[] nums) {
        int length = nums.length;
        // 目前能跳到的最远位置
        int maxPosition = 0;
        // 上次跳跃可达范围右边界（下次的最右起跳点）
        int end = 0;
        //跳跃次数
        int step = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // 到达上次跳跃能到达的右边界了
            if (i == end) {
                // 目前能跳到的最远位置变成了下次起跳位置的有边界
                end = maxPosition;
                // 进入下一次跳跃
                step++;
            }
        }
        return step;
    }
}
