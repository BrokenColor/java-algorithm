package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 66.加一
 *
 * @Author bc
 * @Date 2024/4/5 21:52
 * @Description: 数组
 */
public class LC_66_S_plusOne {
    public static void main(String[] args) {
        LC_66_S_plusOne solution = new LC_66_S_plusOne();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9})));
    }

    /**
     * 给定一个整数数组，数组中的数字代表一个十进制数，对这个数加一并返回新的整数数组。
     * 遍历数组中的数字，从右往左，如果数字是9，则将其变为0，并继续向左遍历；
     * 如果遇到不是9的数字，则将其加1，并返回数组。如果所有数字都是9，则在数组前插入一个1，数组长度加1。
     *
     * @param digits 表示一个非负整数的整数数组。
     * @return 加一后的整数数组。
     */
    public int[] plusOne(int[] digits) {
        int length = digits.length; // 数组的长度
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0; // 如果当前位是9，则将其变为0
            } else {
                digits[i]++; // 如果当前位不是9，则加1并返回
                return digits;
            }
        }
        // 如果所有位都是9，则在数组前插入1，数组长度加1
        digits = new int[length + 1];
        digits[0] = 1;
        return digits;

    }
}
