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

    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int reslut = Integer.MAX_VALUE, sum = 0;
        int left = 0, right = 0;
        while (right < length) {
            //扩大窗口
            sum += nums[right];
            //满足条件
            while (sum >= target) {
                //更新结果
                reslut = Math.min(reslut, right - left + 1);
                //缩小窗口
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return reslut == Integer.MAX_VALUE ? 0 : reslut;
    }
}
