package algorithmCode.InterestingCode;

/**
 * 55.跳跃游戏
 *
 * @Author bc
 * @Date 2023/5/13 23:48
 * @Description:
 */
public class LC_55_M_CanJump {
    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {1, 1, 1, 0};
        LC_55_M_CanJump solution = new LC_55_M_CanJump();
        System.out.println(solution.canJump(nums));

    }

    /**
     * 双循环，暴力
     *
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        int length = nums.length;
        //记录结果
        boolean[] dp = new boolean[length];
        dp[0] = true;
        for (int i = 0; i < length; i++) {
            if (dp[i]) {
                for (int j = 1; i + j < length && j <= nums[i]; j++) {
                    dp[i + j] = true;
                }
            }
        }
        return dp[length - 1];
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        return dp(nums, 0);
    }

    private boolean dp(int[] nums, int index) {
        int length = nums.length;
        if (index == length - 1) {
            return true;
        } else if (index >= length || nums[index] == 0) {
            return false;
        }
        int count = length;
        if (nums[index] + index < length) {
            count = nums[index];
        }
        for (int i = count; i > 0; i--) {
            if (dp(nums, i + index)) {
                return true;
            }
        }
        return false;
    }


    public boolean canJump2(int[] nums) {
        if (nums == null) {
            return false;
        }
        //前n-1个元素能够跳到的最远距离
        int k = 0;
        for (int i = 0; i <= k; i++) {
            //第i个元素能够跳到的最远距离
            int temp = i + nums[i];
            //更新最远距离
            k = Math.max(k, temp);
            //如果最远距离已经大于或等于最后一个元素的下标,则说明能跳过去,退出. 减少循环
            if (k >= nums.length - 1) {
                return true;
            }
        }
        //最远距离k不再改变,且没有到末尾元素
        return false;
    }
}
