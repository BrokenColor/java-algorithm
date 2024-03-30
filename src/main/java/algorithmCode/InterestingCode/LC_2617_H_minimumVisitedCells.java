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

    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, 0, grid) + 1;
    }

    int dp(int i, int j, int[][] grid) {
        if (i == grid.length - 1
                && j == grid[0].length - 1) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = 1; k <= grid[i][j]; k++) {
            if (k + j < grid[0].length) {
                int dp = dp(i, k + j, grid);
                if (dp != -1) {
                    ans = Math.min(ans, dp + 1);
                }
            }
            if (k + i < grid.length) {
                int dp = dp(k + i, j, grid);
                if (dp != -1) {
                    ans = Math.min(ans, dp + 1);
                }
            }
        }
        return memo[i][j] = ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
