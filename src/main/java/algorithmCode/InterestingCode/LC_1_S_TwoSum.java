package algorithmCode.InterestingCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * @Author bc
 * @Date 2023/3/11 11:40
 */
public class LC_1_S_TwoSum {
    /**
     * 查找数组中两个数的索引，使得它们的和等于一个特定目标数。
     *
     * @param nums 包含整数的数组。
     * @param target 目标和。
     * @return 包含两个整数索引的数组，使得 nums[index1] + nums[index2] = target。如果找不到这样的两个数，则返回 null。
     */
    public int[] twoSum(int[] nums, int target) {
        // 使用map存储已遍历的数字及其索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            // 检查map中是否存在目标数
            if (map.containsKey(temp)) {
                int[] solution = {map.get(temp), i};
                return solution;
            }
            // 将当前数字及其索引加入map
            map.put(nums[i], i);
        }
        return null;
    }
}
