package algorithmCode.InterestingCode;

/**
 * 200. 岛屿数量
 *
 * @author guwanli
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

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    //岛屿数量+1
                    res++;
                    //dfs遍历查询
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

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
