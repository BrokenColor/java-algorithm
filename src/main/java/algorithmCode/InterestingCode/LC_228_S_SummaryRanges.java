package algorithmCode.InterestingCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 *
 * @date 2023/7/27 10:24
 */
public class LC_228_S_SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        LC_228_S_SummaryRanges solution = new LC_228_S_SummaryRanges();
        System.out.println(solution.summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int index = 0;
        int length = nums.length;
        while (index < length) {
            int low = index;
            index++;
            while (index < length && nums[index] == nums[index - 1] + 1) {
                index++;
            }
            int high = index - 1;
            StringBuilder stringBuilder = new StringBuilder(Integer.toString(nums[low]));
            if (low < high) {
                stringBuilder.append("->");
                stringBuilder.append(nums[high]);
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }
}
