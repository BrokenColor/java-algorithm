package algorithmCode.InterestingCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * @date 2023/7/19 10:24
 */
public class LC_128_M_LongestConsecutive {

    public static void main(String[] args) {
        LC_128_M_LongestConsecutive solution = new LC_128_M_LongestConsecutive();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums));
    }

    /**
     * 计算数组中最长连续数字序列的长度。
     *
     * @param nums 整型数组，包含不重复的整数。
     * @return 返回数组中最长连续数字序列的长度。
     */
    public int longestConsecutive(int[] nums) {
        int result = 0; // 初始化结果为0
        Set<Integer> numSet = new HashSet<>(); // 使用HashSet存储数组元素，以快速查找

        // 将数组中的所有元素添加到HashSet中
        for (int num : nums) {
            numSet.add(num);
        }

        // 遍历HashSet中的每个元素，查找并计算最长连续序列的长度
        for (Integer num : numSet) {
            // 如果当前元素的前一个元素不存在于HashSet中，则以此元素开始可能的连续序列
            if (!numSet.contains(num - 1)) {
                int currNum = num; // 当前遍历的元素
                int tmp = 1; // 临时变量用于记录当前连续序列的长度

                // 继续向后查找连续的元素，直到找不到下一个连续的元素
                while (numSet.contains(currNum + 1)) {
                    currNum++;
                    tmp++;
                }

                // 更新结果为当前连续序列长度和之前结果的最大值
                result = Math.max(result, tmp);
            }
        }

        return result; // 返回最长连续序列的长度
    }
}
