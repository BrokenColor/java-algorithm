package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 *
 * @Author bc
 * @Date 2023/5/21 15:25
 * @Description:
 */
public class LC_238_M_ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        LC_238_M_ProductExceptSelf solution = new LC_238_M_ProductExceptSelf();
        System.out.println(Arrays.toString(solution.productExceptSelf(nums)));
        System.out.println(Arrays.toString(solution.productExceptSelf1(nums)));
    }

    /**
     * 分别维护左乘积值数组/右乘积值数组
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];

        int[] L = new int[length];
        int[] R = new int[length];
        //左乘积数组
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        //右乘积数组
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }

    /**
     * 双指针解法
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf1(int[] nums) {
        int length = nums.length;
        int Lmultiply = 1, Rmultiply = 1;
        int[] ans = new int[length];
        //填充数组默认值为1
        Arrays.fill(ans,1);
        for (int i = 0; i < length; i++) {
            //从左到右更新左侧乘积[i]=当前值*左侧乘积,左右交汇后当前值侧位右侧乘积
            ans[i] *= Lmultiply;
            //从右到左更新右侧乘积[i]=当前值*右侧乘积,左右交汇后当前值侧位左侧乘积
            ans[length - i - 1] *= Rmultiply;
            //左右交汇后 结果则为左侧乘积*右侧乘积

            //更新左乘积
            Lmultiply *= nums[i];
            //更新右乘积
            Rmultiply *= nums[length - i - 1];
        }
        return ans;
    }

}
