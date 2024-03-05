package algorithmCode.InterestingCode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * @author guwanli
 * @date 2021/12/24 10:24
 */
public class LC_120_M_MinimumTotal {
    public static void main(String[] args) {
        LC_120_M_MinimumTotal solution = new LC_120_M_MinimumTotal();
        //triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Lists.newArrayList(2)));
        triangle.add(new ArrayList<>(Lists.newArrayList(3, 4)));
        triangle.add(new ArrayList<>(Lists.newArrayList(6, 5, 7)));
        triangle.add(new ArrayList<>(Lists.newArrayList(4, 1, 8, 3)));
        System.out.println(solution.minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        //存储下一次结果
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                //取cache中下一层j和j+1中小的 加上三角形中当前值，放入cache中，用于上一层计算
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
