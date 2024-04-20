package algorithmCode.InterestingCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 *
 * @date 2022/1/19 10:24
 */
public class LC_219_S_ContainsNearbyDuplicate {
    public static void main(String[] args) {
        LC_219_S_ContainsNearbyDuplicate solution = new LC_219_S_ContainsNearbyDuplicate();
//        int[] nums = {1, 2, 3, 1};
//        int k = 3;
//        int[] nums = {1, 2, 3, 1, 2, 3};
        int[] nums = {99, 99};
        int k = 2;
        System.out.println(solution.containsNearbyDuplicate(nums, k));
    }

    /**
     * 判断在给定的整数数组中，是否存在两个元素，它们的下标之差的绝对值不超过k，且它们的值相等。
     * 该方法的时间复杂度为O(N*N)，其中N为数组的长度。
     *
     * @param nums 整数数组，包含待检查的元素。
     * @param k 一个整数，表示两个元素下标之差的绝对值最大值。
     * @return 返回一个布尔值，如果存在满足条件的两个元素，则返回true；否则返回false。
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 当数组长度小于等于1且k为0时，认为存在相等元素（因为任意元素与自身满足条件）
        if (nums.length <= 1 && k == 0) return true;
        boolean res = false; // 初始化结果为false

        // 遍历数组中的每个元素，查找其后面k个元素中是否有相等的元素
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length && j <= i + k; j++) {
                // 如果找到相等的元素，则返回true
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        // 如果遍历完整个数组都没有找到满足条件的元素，则返回false
        return res;
    }


    /**
     * 使用哈希表处理
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        int length = nums.length;
        if (length <= 1) return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                int index = map.get(num);
                if (i - index <= k) {
                    return true;
                }
            }
            map.put(num, i);
        }
        return false;
    }
}
