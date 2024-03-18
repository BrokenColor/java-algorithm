package algorithmCode.InterestingCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 15. 三数之和
 * @author guwanli
 * @date 2021/12/3 12:43
 */
public class LC_15_M_3Sum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        LC_15_M_3Sum solution = new LC_15_M_3Sum();
        System.out.println(solution.threeSum(nums));
        System.out.println(solution.threeSum1(nums));
    }

    //双指针
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        //先排序
        Arrays.sort(nums);
        //双指针移动
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;//最小的值大于0，后续不需要遍历
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int res = nums[i] + nums[left] + nums[right];
                if (res == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 首先无论如何先要进行加减操作
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (res < 0) {
                    left++;
                } else if (res > 0) {
                    right--;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int right = length - 1;
            int target = -nums[i];
            for (int j = i + 1; j < length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < right && nums[j] + nums[right] > target) {
                    right--;
                }
                if (j == right) {
                    break;
                }
                if (nums[j] + nums[right] == target) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[right]));
                }
            }
        }

        return ans;
    }
}
