package algorithmCode.InterestingCode;

/**
 * 2529.正整数和负整数的最大计数
 *
 * @Author bc
 * @Date 2024/4/9 23:20
 * @Description: 二分
 */
public class LC_2529_S_maximumCount {
    public static void main(String[] args) {
        LC_2529_S_maximumCount solution = new LC_2529_S_maximumCount();
        System.out.println(solution.maximumCount(new int[]{-2, -1, -1, 1, 2, 3}));
        System.out.println(solution.maximumCount1(new int[]{-2, -1, -1, 1, 2, 3}));
    }

    /**
     * 计算数组中正数和负数的数量，返回较多的数量。
     *
     * @param nums 整型数组，包含任意整数。
     * @return positive 和 negative 中较大的数，表示数组中正数或负数的数量。
     */
    public int maximumCount(int[] nums) {
        int positive = 0, negative = 0;
        // 遍历数组，统计正数和负数的数量
        for (int num : nums) {
            if (num > 0) {
                positive++;
            } else if (num < 0) {
                negative++;
            }
        }
        // 返回正数和负数数量中较大的一个
        return Math.max(positive, negative);
    }

    /**
     * 计算数组中1的最大个数。
     * 该方法首先通过两次调用lowBound方法，分别找到数组中第一个1之前和最后一个1之后的下标，
     * 然后取两者中较大的值作为1的最大个数。
     *
     * @param nums 包含0和1的整数数组。
     * @return 数组中1的最大个数。
     */
    public int maximumCount1(int[] nums) {
        // 找到数组中第一个1之前的位置
        int lowBound1 = lowBound(nums, 0);
        // 找到数组中最后一个1之后的位置
        int lowBound2 = lowBound(nums, 1);
        // 返回数组中1的最大个数
        return Math.max(lowBound1, nums.length - lowBound2);
    }

    /**
     * 在有序数组中寻找第一个大于等于给定值的元素的索引。
     *
     * @param nums 有序数组，数组元素递增排序。
     * @param val 要查找的值。
     * @return 返回第一个大于等于给定值的元素的索引，如果不存在这样的元素，则返回插入点（即应该插入此值的位置）。
     */
    private int lowBound(int[] nums, int val) {
        int left = 0, right = nums.length; // 初始化左右指针，左指针指向数组起始位置，右指针指向数组结束位置。
        while (left < right) { // 当左指针小于右指针时，继续循环。
            int mid = left + (right - left) / 2; // 计算中间位置的索引。
            if (nums[mid] >= val) { // 如果中间位置的元素大于等于目标值，更新右指针。
                right = mid;
            } else { // 否则，更新左指针。
                left = mid + 1;
            }
        }
        return left; // 返回左指针的位置，即为插入点。
    }
}
