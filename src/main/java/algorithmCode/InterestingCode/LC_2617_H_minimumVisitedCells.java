package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 2617.网格图中最少访问的格子数
 *
 * @Author bc
 * @Date 2024/3/22 21:49
 * @Description: 数组
 */
public class LC_2617_H_minimumVisitedCells {

    public static void main(String[] args) {
        LC_2617_H_minimumVisitedCells solution = new LC_2617_H_minimumVisitedCells();
        int[][] grid = {{3, 4, 2, 1}, {4, 2, 3, 1}, {2, 1, 0, 0}, {2, 4, 0, 0}};
        System.out.println(solution.minimumVisitedCells(grid));
    }

    int[][] memo;

    /**
     * 计算访问网格中最小数量的单元格。
     * 给定一个大小为 m x n 的网格，初始位置在左上角，每次可以向右或向下移动一格，目标是到达右下角的位置，并且要求至少访问一个单元格。
     * 功能实现基于动态规划方法。
     *
     * @param grid 网格，一个二维整数数组，表示迷宫地图。
     * @return 返回访问网格中最小数量的单元格数。
     */
    public int minimumVisitedCells(int[][] grid) {
        // 初始化网格的行数和列数
        int m = grid.length, n = grid[0].length;
        // memo数组用于存储到达每个位置的最小访问单元格数
        memo = new int[m][n];
        // 将所有位置的初始值设置为最大整数，表示未访问
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        // 设置终点位置的最小访问单元格数为1
        memo[m - 1][n - 1] = 1;
        // 调用动态规划函数计算最小访问单元格数
        return dp(0, 0, grid);
    }

    /**
     * 使用动态规划算法解决特定问题。
     * @param i 当前位置的行索引
     * @param j 当前位置的列索引
     * @param grid 表示问题环境的二维网格数组
     * @return 返回解决问题的最优解，如果无法解则返回-1。
     */
    int dp(int i, int j, int[][] grid) {
        // 判断当前位置是否已经计算过，如果是，则直接返回结果
        if (memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }
        int ans = Integer.MAX_VALUE;
        // 遍历当前位置能移动的步数
        for (int k = 1; k <= grid[i][j]; k++) {
            // 检查是否可以向右移动，并尝试移动
            if (k + j < grid[0].length) {
                int dp = dp(i, k + j, grid);
                // 如果移动成功，更新答案
                if (dp != -1) {
                    ans = Math.min(ans, dp + 1);
                }
            }
            // 检查是否可以向下移动，并尝试移动
            if (k + i < grid.length) {
                int dp = dp(k + i, j, grid);
                // 如果移动成功，更新答案
                if (dp != -1) {
                    ans = Math.min(ans, dp + 1);
                }
            }
        }
        // 缓存当前位置的结果并返回
        return memo[i][j] = ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
