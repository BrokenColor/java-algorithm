package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @date 2022/1/20 10:33
 */
public class LC_34_M_SearchRange {
    public static void main(String[] args) {
        LC_34_M_SearchRange solution = new LC_34_M_SearchRange();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        Arrays.stream(solution.searchRange(nums, target)).forEach(System.out::print);
    }

    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false) - 1;
        if (left <= right && right < nums.length && nums[right] == target && nums[left] == target) {
            return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
