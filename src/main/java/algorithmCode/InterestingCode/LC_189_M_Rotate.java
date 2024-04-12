package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 189. 旋转数组
 */
public class LC_189_M_Rotate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        LC_189_M_Rotate solution = new LC_189_M_Rotate();
        System.out.println(solution.gcd(k, nums.length));
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
        solution.rotate1(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 对给定的整数数组进行循环右移操作。
     * @param nums 待操作的整数数组。
     * @param k 右移的次数。
     */
    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        // 如果数组长度为1，则无需操作
        if (length == 1) return;
        // 对数组进行k次循环右移操作
        for (int i = 0; i < k; i++) {
            // 定义两个指针，分别指向当前元素和下一个元素
            int p1 = nums[0], p2 = nums[1];
            // 遍历数组，将当前元素和下一个元素进行交换
            for (int j = 0; j < length; j++) {
                // 计算下一个元素的索引，实现循环右移
                int index = (j + 1) % length;
                p2 = nums[index];
                nums[index] = p1;
                p1 = p2;
            }
        }
    }


    /**
     * 将一个数组围绕某个偏移量进行循环旋转。
     * @param nums 待旋转的数组。
     * @param k 旋转的偏移量。
     * 数组 nums 旋转 k 步，其中 k 为非负数。
     * 旋转是按顺时针方向进行的。
     * 示例:
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 旋转 3 步后，数组变为 [5,6,7,1,2,3,4]。
     *
     * 提示:
     * 1 <= nums.length <= 2 * 10^4
     * -2^31 <= nums[i] <= 2^31 - 1
     * 0 <= k <= 10^9
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        // 对偏移量取模，避免不必要的旋转次数
        k = k % length;
        // 计算循环旋转的最小次数，即公因数
        int count = gcd(k, length);
        // 以最小次数进行循环旋转
        for (int i = 0; i < count; i++) {
            int current = i;
            int pre = nums[i];
            // 在一个循环中，不断更新元素的位置
            do {
                // 计算下一个位置的下标
                int next = (current + k) % length;
                // 保存下一个位置的值
                int temp = nums[next];
                // 将当前元素移动到下一个位置
                nums[next] = pre;
                // 将下一个位置的元素更新为当前元素
                pre = temp;
                // 更新当前元素的位置
                current = next;
            } while (current != i);
        }
    }

    // 计算最大公因数，应用欧几里得算法
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
