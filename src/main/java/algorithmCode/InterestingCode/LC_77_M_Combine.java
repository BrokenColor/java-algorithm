package algorithmCode.InterestingCode;

import java.util.LinkedList;
import java.util.List;

/**
 * 77.组合
 *
 * @author bc
 * @date 2022/11/25 16:31
 */
public class LC_77_M_Combine {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }

    private void backtrack(int start, int n, int k) {
        //base case
        if (track.size() == k) {
            //遍历到了第 k 层，收集当前节点的值
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            //选择
            track.add(i);
            //处理下一层
            backtrack(i + 1, n, k);
            //撤销选择
            track.removeLast();
        }
    }
}
