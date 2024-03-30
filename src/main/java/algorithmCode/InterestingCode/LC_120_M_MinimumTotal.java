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

    /**
     * 计算从三角形顶部到底部的最小路径和。
     * @param triangle 表示三角形的二维列表，每个列表元素为整数。
     * @return 返回从顶部到底部的最小路径和。
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 创建一个数组用于存储从顶部到当前位置的最小路径和
        int[] dp = new int[n + 1];
        // 从倒数第二行开始，逐行计算最小路径和
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // 对于当前位置，计算从下一层的j和j+1位置选择较小的路径和，并加上当前位置的值
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        // 最终结果存储在dp[0]中
        return dp[0];
    }
}
