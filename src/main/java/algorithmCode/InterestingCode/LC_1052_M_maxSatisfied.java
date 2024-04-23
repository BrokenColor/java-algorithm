package algorithmCode.InterestingCode;

/**
 * 1052. 爱生气的书店老板
 *
 * @Author bc
 * @Date 2024/4/23 23:32
 * @Description: 滑动窗口
 */
public class LC_1052_M_maxSatisfied {

    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        LC_1052_M_maxSatisfied solution = new LC_1052_M_maxSatisfied();
        System.out.println(solution.maxSatisfied(customers, grumpy, minutes));
    }

    /**
     * 计算在指定时间内，通过改变 grumpy 客户的满意度能够的最大值。
     *
     * @param customers 一个整数数组，表示每个客户的满意度。
     * @param grumpy    一个整数数组，表示每个客户的 grumpy 状态（0 表示满意，1 表示不满意）。
     * @param minutes   指定的时间长度（分钟）。
     * @return 能够的最大满意度总和。
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int res = 0; // 用于存储在指定时间内通过改变 grumpy 状态能够的最大满意度总和
        int total = 0; // 用于存储不改变 grumpy 状态下所有客户的满意度总和

        // 计算不改变 grumpy 状态下所有客户的满意度总和
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }

        int sum = 0; // 用于存储当前窗口内通过改变 grumpy 状态能够的满意度总和
        int left = 0, right = 0; // left 和 right 组成一个窗口，表示当前考虑的时间段

        // 遍历数组，移动右指针，计算每个窗口内的最大满意度总和
        while (right < customers.length) {
            if (grumpy[right] == 1) {
                sum += customers[right];
            }
            right++;

            // 当窗口大小超过指定时间长度时，移动左指针，缩小窗口
            while (right - left > minutes) {
                if (grumpy[left] == 1) {
                    sum -= customers[left];
                }
                left++;
            }
            // 更新结果为当前窗口内的最大满意度总和
            res = Math.max(res, sum);
        }

        // 返回不改变 grumpy 状态下所有客户的满意度总和加上在指定时间内通过改变 grumpy 状态能够的最大满意度总和
        return res + total;
    }
}
