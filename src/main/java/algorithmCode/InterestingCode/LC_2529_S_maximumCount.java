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
}
