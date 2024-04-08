package algorithmCode.InterestingCode;

/**
 * 1020. 飞地的数量
 *
 * @author bc
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
     * 计算被陆地包围的海洋区块的数量。
     *
     * @param grid 二维数组表示地图，其中0代表海，1代表陆地。
     * @return 返回被陆地包围的海洋区块的数量。
     */
    public int numEnclaves(int[][] grid) {
        // 如果地图的行或列为空，则直接返回0
        if (grid.length < 1 || grid[0].length < 1) return 0;
        int res = 0, m = grid.length, n = grid[0].length;

        // 首先通过深度优先搜索（DFS）"打平"地图的边界，将边界上的陆地标记为0
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) dfs(grid, i, 0); // 处理左侧边界
            if (grid[i][n - 1] == 1) dfs(grid, i, n - 1); // 处理右侧边界
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) dfs(grid, 0, i); // 处理上边界
            if (grid[m - 1][i] == 1) dfs(grid, m - 1, i); // 处理下边界
        }

        // 遍历地图，通过DFS找到所有被陆地包围的海洋区块，累加到结果中
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += dfs(grid, i, j);
            }
        }

        return res;
    }


    /**
     * 使用深度优先搜索（DFS）遍历地图，并统计岛屿的数量。
     *
     * @param grid 表示地图的二维数组，1 表示陆地，0 表示水域。
     * @param i 当前遍历位置的行索引。
     * @param j 当前遍历位置的列索引。
     * @return 返回当前岛屿的数量。
     */
    public int dfs(int[][] grid, int i, int j) {
        // 边界条件判断，如果位置越界或者当前位置为水域，则返回岛屿数量为0
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;

        // 如果当前位置已经标记为水域（0），或者本身就是水域，则返回岛屿数量为0
        if (grid[i][j] == 0) return 0;

        // 将当前位置标记为水域（0），表示已经访问过该陆地
        grid[i][j] = 0;

        // 递归地对当前位置的上、下、左、右进行深度优先搜索，并累加搜索到的岛屿数量
        return dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1) + 1;
    }

}
