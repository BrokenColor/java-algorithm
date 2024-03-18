package algorithmCode.InterestingCode;

/**
 * 62. 不同路径
 *
 * @author bc
 * @date 2021/12/22 10:48
 */
public class LC_62_M_UniquePaths {

    public static void main(String[] args) {
        int m = 3, n = 7;
        LC_62_M_UniquePaths solution = new LC_62_M_UniquePaths();
        System.out.println(solution.uniquePaths(m, n));
    }

    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        //fill bound
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        //fill bound
        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

}
