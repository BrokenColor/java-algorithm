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

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
