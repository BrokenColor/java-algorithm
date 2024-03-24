package algorithmCode.InterestingCode;

/**
 * 35. 搜索插入位置
 *
 * @Author bc
 * @Date 2024/3/24 13:51
 * @Description: 二分
 */
public class LC_35_S_searchInsert {

    public static void main(String[] args) {
        LC_35_S_searchInsert solution = new LC_35_S_searchInsert();
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    public int searchInsert(int[] nums, int target) {
        return search(0, nums.length - 1, target, nums);
    }

/**
 * 在有序数组中使用二分查找算法来寻找目标值的索引。
 * @param left 搜索范围的左边界索引。
 * @param right 搜索范围的右边界索引。
 * @param target 目标值，是我们要查找的数值。
 * @param nums 有序数组，是我们要搜索的范围。
 * @return 目标值在数组中的索引，如果不存在则返回左边界索引。
 */
private int search(int left, int right, int target, int[] nums) {
    // 当左边界大于右边界时，表示已经搜索完毕，返回左边界索引
    if (left > right) return left;
    int mid = (left + right) / 2;
    // 计算中间位置，两种写法等价
    // int mid =left + (right - left) / 2;

    // 检查中间位置的数值是否等于目标值
    if (nums[mid] == target) {
        return mid;
    // 如果中间位置的数值大于目标值，那么目标值应该在左半部分
    } else if (nums[mid] > target) {
        return search(left, mid - 1, target, nums);
    // 如果中间位置的数值小于目标值，那么目标值应该在右半部分
    } else if (nums[mid] < target) {
        return search(mid + 1, right, target, nums);
    }
    // 如果上述条件都不满足，返回左边界索引
    return left;
}

}
