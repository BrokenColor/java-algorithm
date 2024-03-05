package algorithmCode.InterestingCode;

/**
 * 540. 有序数组中的单一元素
 *
 * @date 2022/2/14 17:31
 */
public class LC_540_M_SingleNonDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        LC_540_M_SingleNonDuplicate solution = new LC_540_M_SingleNonDuplicate();
        System.out.println(solution.singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
