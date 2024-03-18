package algorithmCode.InterestingCode;

import java.util.HashSet;

/**
 * 694.不同的岛屿数量
 *
 * @Author bc
 * @Date 2024/3/9 22:30
 * @Description: TODO
 */
public class LC_694_M_NumDistinctIslands {
    public static void main(String[] args) {
        LC_694_M_NumDistinctIslands solution = new LC_694_M_NumDistinctIslands();
        int[][] grid = {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1},
        };
        System.out.println(solution.numDistinctIslands(grid));
    }

    int numDistinctIslands(int[][] grid) {
        HashSet<String> island = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 0);
                    island.add(sb.toString());
                }
            }
        }
        return island.size();
    }

    void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;

        if (grid[i][j] == 0) return;

        grid[i][j] = 0;
        sb.append(dir).append(',');
        dfs(grid, i + 1, j, sb, 1);
        dfs(grid, i - 1, j, sb, 2);
        dfs(grid, i, j + 1, sb, 3);
        dfs(grid, i, j - 1, sb, 4);
        sb.append(-dir).append(',');

    }
}
