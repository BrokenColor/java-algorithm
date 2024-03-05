package algorithmCode.InterestingCode;

/**
 * 1020. 飞地的数量
 *
 * @author guwanli
 * @date 2022/1/10 20:05
 */
public class LC_1020_M_NumEnclaves {
    public static void main(String[] args) {
        LC_1020_M_NumEnclaves solution = new LC_1020_M_NumEnclaves();
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};

        int[][] grid1 = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}};
        System.out.println(solution.numEnclaves(grid));
        System.out.println(solution.numEnclaves(grid1));
    }

    /**
     * 0（代表海）或 1（代表陆地）
     *
     * @param grid 地图
     * @return
     */
    public int numEnclaves(int[][] grid) {
        if (grid.length < 1 || grid[0].length < 1) return 0;
        int res = 0, m = grid.length, n = grid[0].length;
        //打平边界
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) dfs(grid, i, 0);
            if (grid[i][n - 1] == 1) dfs(grid, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) dfs(grid, 0, i);
            if (grid[m - 1][i] == 1) dfs(grid, m - 1, i);
        }
        //dfs遍历查找岛屿
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += dfs(grid, i, j);
            }
        }

        return res;
    }

    /**
     * dfs 深度优先遍历
     *
     * @param grid 地图
     * @param i    x
     * @param j    y
     * @return 岛屿数量
     */
    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;

        if (grid[i][j] == 0) return 0;
        //设置成海
        grid[i][j] = 0;
        return dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1) + 1;
    }
}
