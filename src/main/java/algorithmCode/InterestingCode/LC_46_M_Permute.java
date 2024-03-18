package algorithmCode.InterestingCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46 全排列
 * 回溯算法
 *
 * @author bc
 * @date 2021/9/28 8:20 下午
 */
public class LC_46_M_Permute {
    /**
     * //输入：nums = [1,2,3]
     * //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        //【路径】记录
        LinkedList<Integer> track = new LinkedList<>();
        LC_46_M_Permute solution = new LC_46_M_Permute();
        solution.backtrack(nums, track);
        System.out.println(res);
    }

    /**
     * 路径：记录在 track 中
     * 选择列表：nums 中不存在于 track 的那些元素
     * 结束条件：nums 中的元素全都在 track 中出现
     *
     * @param nums
     * @param track
     */
    public void backtrack(int[] nums, LinkedList<Integer> track) {
        //结束条件
        if (nums.length == track.size()) {
            //添加到结果集
            res.add(new LinkedList<>(track));
            return;
        }
        //遍历待处理数组
        for (int num : nums) {
            //当前循环处理过的跳过
            if (track.contains(num)) continue;
            //添加到【路径】中
            track.add(num);
            //向下处理
            backtrack(nums, track);
            //撤销选择
            //track用LinkedList是可以使用removeLast进行撤销选择
            track.removeLast();
        }
    }
}
