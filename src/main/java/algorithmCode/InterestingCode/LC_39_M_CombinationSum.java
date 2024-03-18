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
     *
     * @param nums
     * @param start
     * @param target
     */
    public void backTrace(int[] nums, int start, int target) {
        //添加满足条件的 结果
        if (trackSum == target) {
            result.add(new LinkedList<>(track));
            return;
        }
        //过滤超过目标和 停止向下遍历
        if (trackSum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            //选择元素
            track.add(nums[i]);
            trackSum += nums[i];
            // 同一元素可重复使用，注意参数
            backTrace(nums, i, target);
            //撤销选择
            track.removeLast();
            trackSum -= nums[i];
        }

    }
}
