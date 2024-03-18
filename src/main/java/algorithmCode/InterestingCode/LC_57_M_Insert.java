package algorithmCode.InterestingCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 * 57. 插入区间
 * @date 2023/7/27 10:24
 */
public class LC_57_M_Insert {
    public static void main(String[] args) {
        LC_57_M_Insert solution = new LC_57_M_Insert();
        int[][] intervals = {{1,3},{6,9}};
        int [] newInterval = {2,5};
//        int[][] result = solution.insert(intervals, newInterval);
        int[][] result = solution.insert1(intervals, newInterval);
        System.out.println(Arrays.deepToString(result));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newArr = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            newArr[i] = intervals[i];
        }
        newArr[intervals.length] = newInterval;
        return merge(newArr);
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

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        List<int[]> anslist = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean place = false;
        for (int[] interval : intervals) {
            //右侧是否有重叠
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!place) {
                    anslist.add(new int[]{left, right});
                    place = true;
                }
                anslist.add(interval);
            } else if (interval[1] < left) {//左侧是否重叠
                // 在插入区间的左侧且无交集
                anslist.add(interval);
            } else {//有重叠则跟新左右节点
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!place){
            anslist.add(new int[]{left, right});
        }

        return anslist.toArray(new int[anslist.size()][]);
    }
}
