package algorithmCode.InterestingCode;

import java.util.LinkedList;
import java.util.List;

/**
 * 39.组合总和
 *
 * @author bc
 * @date 2022/12/10 13:44
 */
public class LC_39_M_CombinationSum {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    //记录 track 中的路径和
    int trackSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return result;
        backTrace(candidates, 0, target);
        return result;
    }

    /**
     * 使用回溯法找到所有能够组成目标和的组合。
     * @param nums 整数数组，包含所有可选数字。
     * @param start 开始位置，指定从数组的哪个索引开始搜索。
     * @param target 目标和，搜索的最终目标。
     */
    public void backTrace(int[] nums, int start, int target) {
        // 检查当前组合是否达到目标和
        if (trackSum == target) {
            result.add(new LinkedList<>(track)); // 将满足条件的组合添加到结果集中
            return;
        }
        // 如果当前组合的和已经大于目标和，则无需继续搜索
        if (trackSum > target) {
            return;
        }

        // 在指定范围内遍历数组元素
        for (int i = start; i < nums.length; i++) {
            // 将当前元素加入到当前组合中
            track.add(nums[i]);
            trackSum += nums[i];
            // 递归搜索下一个元素，允许同一元素重复使用
            backTrace(nums, i, target);
            // 撤销当前元素的选择，以尝试其他可能的组合
            track.removeLast();
            trackSum -= nums[i];
        }
    }
}
