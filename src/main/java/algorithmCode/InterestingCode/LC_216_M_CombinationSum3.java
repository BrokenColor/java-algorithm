package algorithmCode.InterestingCode;

import java.util.LinkedList;
import java.util.List;

/**
 * 216.组合总和III
 *
 * @author bc
 * @date 2022/12/10 14:13
 */
public class LC_216_M_CombinationSum3 {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    //记录 track 中的路径和
    int trackSum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0) return result;
        backTrace(k, 1, n);
        return result;
    }

    /**
     * 使用回溯法找到所有和为target，且长度为k的数字组合。
     * @param k 组合的长度
     * @param start 当前组合开始的数字索引
     * @param target 目标和
     */
    public void backTrace(int k, int start, int target) {
        // 如果当前组合长度等于k且和等于target，则将此组合加入结果集
        if (track.size() == k && trackSum == target) {
            result.add(new LinkedList<>(track));
            return;
        }
        // 如果当前和超过target或当前组合长度超过k，则停止深入遍历
        if (trackSum > target || k < track.size()) {
            return;
        }

        // 从start开始尝试所有可能的数字
        for (int i = start; i < 10; i++) {
            // 尝试将当前数字加入组合
            track.add(i);
            trackSum += i;
            // 递归处理下一层
            backTrace(k, i + 1, target);
            // 撤销当前数字的选择
            track.removeLast();
            trackSum -= i;
        }

    }
}
