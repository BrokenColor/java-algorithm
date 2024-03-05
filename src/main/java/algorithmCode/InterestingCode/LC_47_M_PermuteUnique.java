package algorithmCode.InterestingCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47.全排列II
 *
 * @author guwanli
 * @date 2022/11/29 19:46
 */
public class LC_47_M_PermuteUnique {

    public static void main(String[] args) {
        LC_47_M_PermuteUnique solution = new LC_47_M_PermuteUnique();
        int[] nums = {1, 2, 2, 3, 3, 4, 4, 5, 6, 6};
        solution.permuteUnique(nums);
        System.out.println(solution.res);
    }

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    //标记是否被使用
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return res;
        // init false
        used = new boolean[nums.length];
        //排序 把相同的元素放到一起
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        //base case
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //是否被使用过
            if (used[i]) continue;
            //与前一位相同，固定相同的元素在排列中的相对位置
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                // 如果前面的相邻相等元素没有用过，则跳过
                continue;
            }
            //选择
            used[i] = true;
            track.add(nums[i]);
            //处理下一层
            backtrack(nums);
            //回溯
            track.removeLast();
            used[i] = false;
        }
    }
}
