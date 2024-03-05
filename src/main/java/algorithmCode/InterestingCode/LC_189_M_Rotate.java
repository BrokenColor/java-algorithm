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
     * 计算超时
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        if (length == 1) return;
        for (int i = 0; i < k; i++) {
            int p1 = nums[0], p2 = nums[1];
            for (int j = 0; j < length; j++) {
                int index = (j + 1) % length;
                p2 = nums[index];
                nums[index] = p1;
                p1 = p2;
            }
        }
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int count = gcd(k, length);
        for (int i = 0; i < count; i++) {
            int current = i;
            int pre = nums[i];
            do {
                //计算下一个位置下标()
                int next = (current + k) % length;
                //保存next坐标值
                int temp = nums[next];
                //把要移动过来的值复制到next坐标处
                nums[next] = pre;
                //把next值赋值待移动
                pre = temp;
                //指针前进一步
                current = next;
            } while (current != i);
        }
    }

    /**
     * 求最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}
