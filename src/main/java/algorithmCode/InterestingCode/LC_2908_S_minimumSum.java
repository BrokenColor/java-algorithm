package algorithmCode.InterestingCode;

/**
 * 2908. 元素和最小的山形三元组 I
 *
 * @Author bc
 * @Date 2024/3/29 21:38
 * @Description: 数组
 */
public class LC_2908_S_minimumSum {
    public static void main(String[] args) {
        LC_2908_S_minimumSum solution = new LC_2908_S_minimumSum();
        System.out.println(solution.minimumSum(new int[]{8, 6, 1, 5, 3}));
    }

    /**
     * 计算数组中最小的三数之和。
     * 该函数遍历数组中的每个元素，并分别找到其左侧和右侧的最小值，然后判断当前元素是否被两侧的最小值所小于，如果是，则更新结果为左侧、当前和右侧最小值的和。
     * 最终返回所有可能的最小三数之和中的最小值。如果没有找到满足条件的三数之和，则返回-1。
     *
     * @param nums 整型数组，表示输入的数组。
     * @return 返回最小的三数之和，如果没有满足条件的三数之和，则返回-1。
     */
    public int minimumSum(int[] nums) {
        int length = nums.length; // 数组长度
        int res = Integer.MAX_VALUE; // 初始化结果为整型最大值，用于比较和更新最小三数之和
        for (int i = 1; i < length - 1; i++) { // 遍历数组中除首尾元素的其他元素
            int left = i - 1; // 左侧起始位置
            int leftMin = nums[left]; // 左侧最小值初始化为当前位置的值
            // 从左侧向内寻找最小值
            while (left >= 0) {
                leftMin = Math.min(leftMin, nums[left]);
                left--;
            }
            int right = i + 1; // 右侧起始位置
            int rightMin = nums[right]; // 右侧最小值初始化为当前位置的值
            // 从右侧向内寻找最小值
            while (right < length) {
                rightMin = Math.min(rightMin, nums[right]);
                right++;
            }
            // 如果当前位置元素同时小于左右两侧的最小值，则更新结果
            if (leftMin < nums[i] && rightMin < nums[i]) {
                res = Math.min(res, leftMin + nums[i] + rightMin);
            }
        }
        // 如果结果未被更新，则表示未找到满足条件的三数之和，返回-1；否则返回最小三数之和
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
