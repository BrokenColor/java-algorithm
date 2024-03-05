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
     * 定义两个指针，p1 p2=p1+k;,判断两个指针中间是否有相等元素
     * O(N*N)
     *
     * @param nums 数组
     * @param k    区间
     * @return res
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1 && k == 0) return true;
        boolean res = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length && j <= i + k; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
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
