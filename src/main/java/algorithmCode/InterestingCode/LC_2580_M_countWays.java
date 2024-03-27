package algorithmCode.InterestingCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2580.统计将重叠区间合并成组的方案数
 *
 * @Author bc
 * @Date 2024/3/27 23:02
 * @Description: 数组
 */
public class LC_2580_M_countWays {
    public static void main(String[] args) {
        LC_2580_M_countWays solution = new LC_2580_M_countWays();
        int[][] ranges = {{6, 10}, {5, 15}};
        System.out.println(solution.countWays(ranges));
    }
    static final int MOD = 1000000007;
    /**
     * 统计通过合并区间可以得到的唯一组合数量。
     *
     * @param ranges 一个二维数组，表示多个区间的开始和结束位置。每个区间用长度为2的一维数组表示。
     * @return 返回通过合并区间所能得到的唯一组合数量。
     */
    public int countWays(int[][] ranges) {
        // 根据区间的开始值对ranges进行排序
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        int n = ranges.length;
        int res = 1; // 初始化结果为1
        // 遍历排序后的区间数组，合并相邻的区间
        for (int cur = 0; cur < n; ) {
            int curTail = ranges[cur][1]; // 当前区间的结束位置
            int next = cur + 1; // 下一个待处理的区间索引
            // 寻找所有可以与当前区间合并的区间，并更新当前区间的结束位置
            while (next < n && ranges[next][0] <= curTail) {
                curTail = Math.max(ranges[next][1], curTail);
                next++;
            }
            // 根据合并的区间数量，每有两个区间合并，结果乘以2
            res = res * 2 % MOD;
            cur = next;
        }
        return res;
    }
}
