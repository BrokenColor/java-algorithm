package algorithmCode.InterestingCode;

/**
 * 1254. 统计封闭岛屿的数目
 *
 * @author guwanli
 * @date 2022/1/10 11:51
 */
public class LC_1254_M_ClosedIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}};

        LC_1254_M_ClosedIsland solution = new LC_1254_M_ClosedIsland();
        System.out.println(solution.closedIsland(grid));
    }

    /**
     * 陆地（记号为 0 ）水域（记号为 1 ）
     *
     * @param grid
     * @return
     */
    public int closedIsland(int[][] grid) {
        if (grid.length < 1 || grid[0].length < 1) return 0;
        int res = 0, m = grid.length, n = grid[0].length;
        //把边缘的陆地打平
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) dfs(grid, i, 0);//第一列
            if (grid[i][n - 1] == 0) dfs(grid, i, n - 1);//最后一列
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 0) dfs(grid, 0, i);//第一行
            if (grid[m - 1][i] == 0) dfs(grid, m - 1, i);//最后一行
        }
        //寻找封闭岛屿
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
                }
            }

        }

        return res;
    }

    /**
     * 深度遍历
     *
     * @param grid 数组
     * @param i    x
     * @param j    y
     */
    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;

        if (grid[i][j] == 1) return;

        //打平
        grid[i][j] = 1;

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

}
