package algorithmCode.InterestingCode;

/**
 * 2789.合并后数组中最大元素
 *
 * @Author bc
 * @Date 2024/3/14 10:14
 * @Description: TODO
 */
public class LC_2789_M_MaxArrayValue {

    public static void main(String[] args) {
        LC_2789_M_MaxArrayValue solution = new LC_2789_M_MaxArrayValue();
        int[] nums = {2, 3, 7, 9, 3};
        System.out.println(solution.maxArrayValue(nums));
    }

    public long maxArrayValue(int[] nums) {
        if (nums.length == 1) return nums[0];
        return recursion(nums, 0);
    }

    /**
     * 递归
     * @param nums
     * @param index
     * @return
     */
    long recursion(int[] nums, int index) {
        if (index >= nums.length) return 0;
        //最后一个元素 直接返回该元素
        if (index == nums.length - 1) {
            return nums[index];
        }
        //处理下一个节点
        long res = recursion(nums, index + 1);
        //当前元素大于 子数组结果 则是用当前元素作为结果
        if (nums[index] > res) {
            res = nums[index];
        } else {
            //结果 加上当前元素的值
            res += nums[index];
        }
        return res;
    }
}
