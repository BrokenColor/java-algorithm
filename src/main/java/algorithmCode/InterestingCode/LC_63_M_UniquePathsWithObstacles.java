package algorithmCode.InterestingCode;

/**
 * 63. 不同路径 II
 *
 * @author bc
 * @date 2021/12/22 18:16
 */
public class LC_63_M_UniquePathsWithObstacles {
    public static void main(String[] args) {
        LC_63_M_UniquePathsWithObstacles solution = new LC_63_M_UniquePathsWithObstacles();
        int[][] obstacleGrid = new int[2][2];
        obstacleGrid[0][1] = 1;
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length < 0) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //fill bound
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        //fill bound
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //Crossing obstacles
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
