package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * @Author bc
 * @Date 2023/6/4 11:21
 * @Description:
 */
public class LC_167_S_TwoSum {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        LC_167_S_TwoSum solution = new LC_167_S_TwoSum();
        System.out.println(Arrays.toString(solution.twoSum(numbers, 9)));
    }

    /**
     * 在给定数组中找到两个数，使得它们的和等于一个特定目标数，并返回它们的数组下标。
     *
     * @param numbers 一个整数数组
     * @param target 目标和
     * @return 包含两个整数下标的数组，它们对应的元素之和等于目标数。如果找不到这样的两个数，则返回包含-1的数组。
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1; // 初始化左右指针分别指向数组的起始和末尾
        while (left < right) { // 当左指针小于右指针时循环，确保遍历完整个数组
            int sum = numbers[left] + numbers[right]; // 计算当前左右指针所指元素的和
            if (sum == target) { // 如果和等于目标数
                return new int[]{left + 1, right + 1}; // 返回左右指针的下标（加一以匹配输入数组的索引形式）
            } else if (sum < target) { // 如果和小于目标数
                left++; // 左指针向右移动
            } else { // 如果和大于目标数
                right--; // 右指针向左移动
            }
        }
        return new int[]{-1, -1}; // 如果没有找到符合条件的两个数，返回包含-1的数组
    }
}
