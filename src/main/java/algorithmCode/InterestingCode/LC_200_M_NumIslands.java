package algorithmCode.InterestingCode;

/**
 * 200. 岛屿数量
 *
 * @author bc
 * @date 2022/1/7 19:10
 */
public class LC_200_M_NumIslands {
    public static void main(String[] args) {
        LC_200_M_NumIslands solution = new LC_200_M_NumIslands();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(solution.numIslands(grid));
    }

    /**
     * 计算给定二维字符网格中的岛屿数量。
     * 岛屿被定义为由 '1'（陆地）字符组成的任意连接的区域，且该区域四面八方都被 '0'（水域）包围。
     *
     * @param grid 二维字符网格，由 '1'（陆地）和 '0'（水域）组成。
     * @return 岛屿的数量。
     */
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // 发现陆地，岛屿数量加一
                    res++;
                    // 使用深度优先搜索（DFS）遍历相连的陆地
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    /**
     * 使用深度优先搜索（DFS）遍历与指定陆地相连的所有陆地。
     *
     * @param grid 二维字符网格
     * @param i 当前遍历位置的行索引
     * @param j 当前遍历位置的列索引
     */

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        //dfs到0则结束
        if (grid[i][j] == '0') return;
        //把连接的1设置成0，防止重复访问
        grid[i][j] = '0';
        dfs(grid, i - 1, j);//向上
        dfs(grid, i + 1, j);//向下
        dfs(grid, i, j - 1);//向左
        dfs(grid, i, j + 1);//向右
    }
}
