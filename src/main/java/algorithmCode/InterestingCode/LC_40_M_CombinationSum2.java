package algorithmCode.InterestingCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40.组合II
 *
 * @author guwanli
 * @date 2022/11/26 22:55
 */
public class LC_40_M_CombinationSum2 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    //组合和
    int trackSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return res;
        // 先排序，让相同的元素靠在一起
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target) {
        // base case，达到目标和，找到符合条件的组合
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        //base case，超过目标和，直接结束
        if (trackSum > target) {
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            // 剪枝逻辑，值相同的树枝，只遍历第一条
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            //做选择
            trackSum += candidates[i];
            track.add(candidates[i]);
            // 递归遍历下一层回溯树
            backtrack(candidates, i + 1, target);
            //撤销选择
            track.removeLast();
            trackSum -= candidates[i];
        }


    }
}
