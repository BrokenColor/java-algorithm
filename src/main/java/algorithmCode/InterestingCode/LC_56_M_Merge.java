package algorithmCode.InterestingCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 *
 * @date 2023/7/27 10:24
 */
public class LC_56_M_Merge {

    public static void main(String[] args) {
        LC_56_M_Merge solution = new LC_56_M_Merge();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(solution.merge(intervals)));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //根据节点左侧元素排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merge = new ArrayList<>();
        for (int[] interval : intervals) {
            int left = interval[0], right = interval[1];
            //第一次或者最后一次合并的区间右侧元素比当前区间左侧小，添加新区间
            if (merge.size() == 0 || merge.get(merge.size() - 1)[1] < left) {
                merge.add(new int[]{left, right});
            } else {
                //更新合并的区间左侧节点
                merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], right);
            }
        }
        //转化成数组返回
        return merge.toArray(new int[merge.size()][2]);
    }
}
