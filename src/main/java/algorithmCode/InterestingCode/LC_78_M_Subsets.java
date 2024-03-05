package algorithmCode.InterestingCode;

import java.util.LinkedList;
import java.util.List;

/**
 * 78.子集
 *
 * @author bc
 * @date 2022/11/25 13:09
 */
public class LC_78_M_Subsets {

    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        //添加子集
        res.add(new LinkedList<>(track));
        //从start 开始
        for (int i = start; i < nums.length; i++) {
            //添加选择的元素到结果集中
            track.add(nums[i]);
            //递归下一层
            backtrack(nums, i + 1);
            //撤回选择的元素
            track.removeLast();
        }
    }
}
