package algorithmCode.InterestingCode;

/**
 * 704. 二分查找
 *
 * @date 2022/1/16 16:27
 */
public class LC_704_S_Search {
    public static void main(String[] args) {
        LC_704_S_Search solution = new LC_704_S_Search();
        int[] nums = {-1, 0, 3, 5, 9, 9, 12};
//        int[] nums = {9};
        int target = 9;
        System.out.println(solution.search1(nums, target));
//        System.out.println(solution.search1(nums1, target));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mind = left + (right - left) / 2;
            if (nums[mind] == target) {
                return mind;
            } else if (nums[mind] > target) {
                right = mind - 1;
            } else if (nums[mind] < target) {
                left = mind + 1;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int leftBound = leftBound(nums, target);
        int rightBound = rightBound(nums, target);
        if (leftBound >= 0 && rightBound >= 0) {
            return rightBound - leftBound + 1;
        }
        return 0;
    }

    public int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1, total = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left == nums.length) return -1;
        return nums[left] == target ? left : -1;
    }

    public int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1, total = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left-1 < 0) return -1;
        return nums[left - 1] == target ? (left - 1) : -1;
    }

}
