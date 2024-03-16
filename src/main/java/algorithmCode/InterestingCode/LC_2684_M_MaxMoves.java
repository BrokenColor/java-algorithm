package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 * 2684.矩阵中移动的最大次数
 *
 * @Author bc
 * @Date 2024/3/16 22:07
 * @Description: dfs
 */
public class LC_2684_M_MaxMoves {
    public static void main(String[] args) {
        LC_2684_M_MaxMoves solution = new LC_2684_M_MaxMoves();
        int[][] grid = {{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}};
        System.out.println(solution.maxMoves(grid));
    }

    int[][] memo;

    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        //缓存处理过的节点
        memo = new int[m + 1][n + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            //右上的步数
            int a = stackBuck(grid, grid[i][0], i - 1, 1);
            //根据题意可知 最大步数为 n-1； 所以只要找到 就不用再往下找了，
            if (a == n - 1) return a;
            //右边的步数
            int b = stackBuck(grid, grid[i][0], i, 1);
            //根据题意可知 最大步数为 n-1； 所以只要找到 就不用再往下找了，
            if (b == n - 1) return b;
            //右下的步数
            int c = stackBuck(grid, grid[i][0], i + 1, 1);
            //根据题意可知 最大步数为 n-1； 所以只要找到 就不用再往下找了，
            if (c == n - 1) return c;
            int res = Math.max(a, Math.max(b, c));
            result = Math.max(res, result);
        }
        return result;
    }

    int stackBuck(int[][] grid, int target, int row, int col) {
        //边界判断
        if (row < 0 || col < 0
                || row >= grid.length
                || col >= grid[0].length) return 0;
        //不满足的
        if (target >= grid[row][col]) {
            return 0;
        }
        //查找缓存
        if (memo[row][col] != -1) return memo[row][col];
        //处理下一个节点
        int a = stackBuck(grid, grid[row][col], row - 1, col + 1);
        int b = stackBuck(grid, grid[row][col], row, col + 1);
        int c = stackBuck(grid, grid[row][col], row + 1, col + 1);
        int max = Math.max(a, Math.max(b, c));
        //更新缓存
        memo[row][col] = max + 1;
        return memo[row][col];
    }

}
