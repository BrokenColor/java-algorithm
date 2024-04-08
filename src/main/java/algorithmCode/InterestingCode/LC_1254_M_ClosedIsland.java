package algorithmCode.InterestingCode;

/**
 * 1254. 统计封闭岛屿的数目
 *
 * @author bc
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
     * 计算封闭的岛屿数量。岛屿被水域包围，且岛屿上的陆地是连通的。
     * 0 表示陆地，1 表示水域。
     *
     * @param grid 二维数组表示的地图
     * @return 封闭岛屿的数量
     */
    public int closedIsland(int[][] grid) {
        // 如果地图为空或尺寸为零，则不存在岛屿
        if (grid.length < 1 || grid[0].length < 1) return 0;
        int res = 0, m = grid.length, n = grid[0].length;

        // 首先将边界上的陆地通过深度优先搜索"打平"，即标记为水域
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) dfs(grid, i, 0); // 处理第一列的陆地
            if (grid[i][n - 1] == 0) dfs(grid, i, n - 1); // 处理最后一列的陆地
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 0) dfs(grid, 0, i); // 处理第一行的陆地
            if (grid[m - 1][i] == 0) dfs(grid, m - 1, i); // 处理最后一行的陆地
        }

        // 遍历地图，寻找并标记封闭的岛屿
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++; // 发现一个封闭岛屿
                    dfs(grid, i, j); // 标记该岛屿及其连接的陆地为水域
                }
            }
        }

        return res;
    }


    /**
     * 深度优先搜索遍历二维数组
     * 用于标记已访问过的元素，避免重复访问
     *
     * @param grid 二维数组，表示地图或其他需要遍历的结构
     * @param i 当前遍历元素的行索引
     * @param j 当前遍历元素的列索引
     */
    private void dfs(int[][] grid, int i, int j) {
        // 检查索引是否越界，或当前元素已被访问过（值为1）
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1) return;

        // 标记当前元素为已访问
        grid[i][j] = 1;

        // 递归遍历四个相邻的方向
        dfs(grid, i - 1, j); // 上
        dfs(grid, i + 1, j); // 下
        dfs(grid, i, j - 1); // 左
        dfs(grid, i, j + 1); // 右
    }


}
