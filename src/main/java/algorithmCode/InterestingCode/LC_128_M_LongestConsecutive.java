package algorithmCode.InterestingCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * @date 2023/7/19 10:24
 */
public class LC_128_M_LongestConsecutive {

    public static void main(String[] args) {
        LC_128_M_LongestConsecutive solution = new LC_128_M_LongestConsecutive();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (Integer num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currNum = num;
                int tmp = 1;
                while (numSet.contains(currNum + 1)) {
                    currNum++;
                    tmp++;
                }
                result = Math.max(result, tmp);
            }
        }

        return result;
    }
}
