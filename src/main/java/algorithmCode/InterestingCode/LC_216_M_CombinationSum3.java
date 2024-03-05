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

    public void backTrace(int k, int start, int target) {
        //添加满足条件的 结果
        if (track.size() == k && trackSum == target) {
            result.add(new LinkedList<>(track));
            return;
        }
        //过滤超过目标和 或者track大小超过k 停止向下遍历
        if (trackSum > target || k < track.size()) {
            return;
        }

        for (int i = start; i < 10; i++) {
            //选择元素
            track.add(i);
            trackSum += i;
            // 处理下一层
            backTrace(k, i + 1, target);
            //撤销选择
            track.removeLast();
            trackSum -= i;
        }

    }
}
