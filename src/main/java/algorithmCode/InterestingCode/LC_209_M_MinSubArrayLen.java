package algorithmCode.InterestingCode;

/**
 * 209. 长度最小的子数组
 *
 * @Author bc
 * @Date 2023/6/7 21:05
 * @Description: 滑动窗口
 */
public class LC_209_M_MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
//        int[] nums = {1, 4, 4};
        LC_209_M_MinSubArrayLen solution = new LC_209_M_MinSubArrayLen();
        System.out.println(solution.minSubArrayLen(7, nums));
        System.out.println(solution.minSubArrayLen(4, nums));
    }

    /**
     * 查找数组中最小的子数组长度，使其元素之和大于等于目标值。
     * @param target 目标值
     * @param nums 整数数组
     * @return 最小的子数组长度；如果不存在满足条件的子数组，则返回0。
     */
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int reslut = Integer.MAX_VALUE, sum = 0;
        int left = 0, right = 0;

        // 遍历数组，通过移动左右指针来扩大和缩小窗口，寻找满足条件的子数组
        while (right < length) {
            // 扩大窗口，将右边的元素加入窗口的和中
            sum += nums[right];

            // 当窗口的和大于等于目标值时，尝试更新结果并缩小窗口
            while (sum >= target) {
                // 更新结果为当前窗口长度和之前结果的较小值
                reslut = Math.min(reslut, right - left + 1);

                // 缩小窗口，将左边的元素从窗口的和中减去
                sum -= nums[left];
                left++;
            }
            right++;
        }

        // 如果最终结果没有被更新（即reslut仍为初始值），则表示没有找到满足条件的子数组，返回0
        return reslut == Integer.MAX_VALUE ? 0 : reslut;
    }
}
