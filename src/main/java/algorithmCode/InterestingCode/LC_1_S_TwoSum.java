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
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                int[] solution = {map.get(temp), i};
                return solution;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
